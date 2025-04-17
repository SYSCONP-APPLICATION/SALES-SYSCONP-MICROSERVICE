package sales.sysconp.microservice.config.features.installment.application.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentCreateRequestDTO;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentCreatedResponseDTO;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentResponseDTO;
import sales.sysconp.microservice.features.installment.application.ports.in.InstallmentServiceInPort;
import sales.sysconp.microservice.features.installment.domain.enums.InstallmentTypeEnum;
import sales.sysconp.microservice.features.installment.domain.enums.MonthEnum;
import sales.sysconp.microservice.features.installment.domain.mappers.InstallmentMapper;
import sales.sysconp.microservice.features.installment.domain.models.InstallmentModel;
import sales.sysconp.microservice.features.installment.infrastructure.repository.InstallmentRepositoryAdapter;
import sales.sysconp.microservice.features.sale.domain.enums.SaleType;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.features.sale.infrastructure.repository.SaleRepositoryAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class InstallmentService implements InstallmentServiceInPort {
    private final InstallmentRepositoryAdapter installmentRepositoryAdapter;
    private final SaleRepositoryAdapter saleRepositoryAdapter;
    private final InstallmentMapper installmentMapper;

    public InstallmentService(InstallmentRepositoryAdapter installmentRepositoryAdapter, SaleRepositoryAdapter saleRepositoryAdapter, InstallmentMapper installmentMapper) {
        this.installmentRepositoryAdapter = installmentRepositoryAdapter;
        this.saleRepositoryAdapter = saleRepositoryAdapter;
        this.installmentMapper = installmentMapper;
    }

    @Override
    public InstallmentResponseDTO getInstallmentById(Long id) {
        return installmentMapper.toResponseDTO(installmentRepositoryAdapter.findById(id).orElseThrow());
    }

    @Override
    public InstallmentResponseDTO getInstallmentByUUID(UUID uuid) {
        return installmentMapper.toResponseDTO(installmentRepositoryAdapter.findByUUID(uuid).orElseThrow());
    }

    @Override
    public List<InstallmentResponseDTO> getAllInstallmentsBySaleId(Long saleId) {
        this.saleRepositoryAdapter
                .findById(saleId)
                .orElseThrow(() -> new NoSuchElementException("Venda não encontrada"));

        return installmentRepositoryAdapter.findAllBySaleId(saleId).stream()
                .map(installmentMapper::toResponseDTO)
                .toList();
    }

    @Transactional
    @Override
    public InstallmentCreatedResponseDTO createInstallment(InstallmentCreateRequestDTO request) {
        SaleModel sale = this.saleRepositoryAdapter
                .findById(request.getSaleId())
                .orElseThrow(() -> new NoSuchElementException("Venda não encontrada"));

        if (sale.getInstallments() != null && !sale.getInstallments().isEmpty()) {
            throw new IllegalArgumentException("Esta venda já tem installments");
        }

        if (sale.getSaleType() != SaleType.INSTALLMENT) {
            throw new IllegalArgumentException("Só é possível gerar parcelas para vendas a prazo.");
        }

        if (sale.getPaymentConfiguration() == null) {
            throw new IllegalArgumentException("Esta venda não tem um payment configuration - crie uma");
        }

        Long limitDay = sale.getPaymentConfiguration().getApplyDebtAfter();
        int paymentDay = Math.toIntExact(sale.getPaymentConfiguration().getDayOfMonth());

        double initial = sale.getInitialValue() != null ? sale.getInitialValue() : 0.0;
        double discount = sale.getDiscount() != null ? sale.getDiscount() : 0.0;
        double global = sale.getGlobalValue() != null ? sale.getGlobalValue() : 0.0;
        double valuePerInstallment = sale.getInstallmentValue();

        double remaining = global - (initial + discount);

        if (remaining <= 0) {
            throw new IllegalArgumentException("Valor restante é zero ou negativo. Não é necessário gerar parcelas.");
        }

        int totalInstallments = (int) Math.ceil(remaining / valuePerInstallment);
        List<InstallmentModel> installments = new ArrayList<>();

        LocalDate now = LocalDate.now();
        LocalDate baseDate = (limitDay == null || now.getDayOfMonth() <= limitDay) ? now : now.plusMonths(1);

        baseDate = baseDate.withDayOfMonth(1);

        LocalDateTime paymentDate = LocalDateTime.of(
                baseDate.getYear(),
                baseDate.getMonth(),
                Math.min(paymentDay, baseDate.lengthOfMonth()),
                12, 0
        );

        double remainingAmount = remaining;

        for (int i = 0; i < totalInstallments; i++) {
            double installmentValue = Math.min(valuePerInstallment, remainingAmount);

            InstallmentModel installment = new InstallmentModel();
            installment.setValue(installmentValue);
            installment.setIndex(i + 1);
            installment.setSale(sale); // importante!
            installment.setMonth(MonthEnum.valueOf(paymentDate.getMonth().toString()));
            installment.setType(InstallmentTypeEnum.INSTALLMENT);
            installment.setPaymentDate(paymentDate);
            installment.setYear(paymentDate.getYear());

            installments.add(installment);

            remainingAmount -= installmentValue;

            paymentDate = paymentDate.plusMonths(1).withDayOfMonth(
                    Math.min(paymentDay, paymentDate.plusMonths(1).toLocalDate().lengthOfMonth())
            );
        }

        this.installmentRepositoryAdapter.saveAll(installments);

        InstallmentModel lastInstallment = installments.get(installments.size() - 1);

        return new InstallmentCreatedResponseDTO(
                installments.size(),
                lastInstallment.getPaymentDate(),
                InstallmentTypeEnum.INSTALLMENT,
                lastInstallment.getMonth(),
                lastInstallment.getYear()
        );
    }

    @Override
    public List<InstallmentResponseDTO> getAllInstallmentsBySaleUUID(UUID saleUUID) {
        this.saleRepositoryAdapter
                .findByUUID(saleUUID)
                .orElseThrow(() -> new NoSuchElementException("Sale not found with UUID: " + saleUUID));

        return installmentRepositoryAdapter.findBySaleUuid(saleUUID).stream()
                .map(installmentMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void deleteInstallmentById(Long id) {
        this.installmentRepositoryAdapter.findById(id).orElseThrow(() -> new NoSuchElementException("Installment not found with id: " + id));

        installmentRepositoryAdapter.deleteById(id);
    }
}
