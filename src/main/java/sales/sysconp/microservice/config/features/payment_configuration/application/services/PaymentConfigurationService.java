package sales.sysconp.microservice.config.features.payment_configuration.application.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationCreateRequestDTO;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationResponseDTO;
import sales.sysconp.microservice.features.payment_configuration.application.dto.PaymentConfigurationUpdateRequestDTO;
import sales.sysconp.microservice.features.payment_configuration.application.ports.in.PaymentConfigurationInServicePort;
import sales.sysconp.microservice.features.payment_configuration.application.ports.out.PaymentConfigurationRepositoryOutPort;
import sales.sysconp.microservice.features.payment_configuration.domain.mappers.PaymentConfigurationMapper;
import sales.sysconp.microservice.features.payment_configuration.domain.models.PaymentConfigurationModel;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.features.sale.infrastructure.repository.SaleRepositoryAdapter;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class PaymentConfigurationService implements PaymentConfigurationInServicePort {
    private final PaymentConfigurationRepositoryOutPort paymentConfigurationRepository;
    private final SaleRepositoryAdapter saleRepositoryAdapter;
    private final PaymentConfigurationMapper mapper;

    public PaymentConfigurationService(PaymentConfigurationRepositoryOutPort paymentConfigurationRepository, SaleRepositoryAdapter saleRepositoryAdapter, PaymentConfigurationMapper mapper) {
        this.paymentConfigurationRepository = paymentConfigurationRepository;
        this.saleRepositoryAdapter = saleRepositoryAdapter;
        this.mapper = mapper;
    }

    @Override
    public PaymentConfigurationResponseDTO getPaymentConfigurationById(Long id) {
        return paymentConfigurationRepository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Payment configuration with id " + id + " not found"));
    }

    @Override
    public PaymentConfigurationResponseDTO getPaymentConfigurationByUUID(UUID uuid) {
        return paymentConfigurationRepository.findByUUID(uuid)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Payment configuration with uuid " + uuid + " not found"));
    }

    @Override
    public PaymentConfigurationResponseDTO getPaymentConfigurationBySaleId(Long saleId) {
        return paymentConfigurationRepository.findBySaleId(saleId).stream()
                .findFirst()
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Payment configuration with sale id " + saleId + " not found"));
    }

    @Transactional
    @Override
    public PaymentConfigurationResponseDTO createPaymentConfiguration(PaymentConfigurationCreateRequestDTO request) {
        SaleModel sale = saleRepositoryAdapter
                .findById(request.getSaleId())
                .orElseThrow(() -> new NoSuchElementException("Sale with id " + request.getSaleId() + " not found"));

        PaymentConfigurationModel paymentConfigurationModel = new PaymentConfigurationModel();

        paymentConfigurationModel.setApplyDebtAfter(request.getApplyDebtAfter());
        paymentConfigurationModel.setDayOfMonth(request.getDayOfMonth());

        sale.setPaymentConfiguration(paymentConfigurationModel);
        this.saleRepositoryAdapter.save(sale);

        return mapper.toResponseDTO(paymentConfigurationRepository.save(paymentConfigurationModel));
    }

    @Override
    public PaymentConfigurationResponseDTO updatePaymentConfiguration(Long id, PaymentConfigurationUpdateRequestDTO request) {
        PaymentConfigurationModel model = paymentConfigurationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Payment configuration with id " + id + " not found"));

        if (request.getDayOfMonth() != null) {
            model.setDayOfMonth(request.getDayOfMonth());
        }
        if (request.getApplyDebtAfter() != null) {
            model.setApplyDebtAfter(request.getApplyDebtAfter());
        }

        return mapper.toResponseDTO(paymentConfigurationRepository.save(model));
    }

    @Override
    public void deleteById(Long id) {
        PaymentConfigurationModel model = this.paymentConfigurationRepository
                .findById(id).orElseThrow(() -> new NoSuchElementException("Payment configuration with id " + id + " not found"));

        SaleModel sale = model.getSale();

        if (sale != null) {
            sale.setPaymentConfiguration(null);
            saleRepositoryAdapter.save(sale);
        }

        paymentConfigurationRepository.deleteById(id);
    }
}