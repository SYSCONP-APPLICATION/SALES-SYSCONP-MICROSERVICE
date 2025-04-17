package sales.sysconp.microservice.config.features.payment_method.application.services;

import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodCreateRequestDTO;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodResponseDTO;
import sales.sysconp.microservice.features.payment_method.application.dto.PaymentMethodUpdateRequestDTO;
import sales.sysconp.microservice.features.payment_method.application.ports.in.PaymentMethodServiceInPort;
import sales.sysconp.microservice.features.payment_method.domain.mappers.PaymentMethodMapper;
import sales.sysconp.microservice.features.payment_method.domain.models.PaymentMethodModel;
import sales.sysconp.microservice.features.payment_method.infrastructure.repository.PaymentMethodRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentMethodService implements PaymentMethodServiceInPort {
    private final PaymentMethodRepositoryAdapter paymentMethodRepositoryAdapter;
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final PaymentMethodMapper paymentMethodMapper;

    public PaymentMethodService(PaymentMethodRepositoryAdapter paymentMethodRepositoryAdapter, CompanyRepositoryAdapter companyRepositoryAdapter, PaymentMethodMapper paymentMethodMapper) {
        this.paymentMethodRepositoryAdapter = paymentMethodRepositoryAdapter;
        this.companyRepositoryAdapter = companyRepositoryAdapter;
        this.paymentMethodMapper = paymentMethodMapper;
    }

    @Override
    public PaymentMethodResponseDTO getPaymentMethodById(Long id) {
        return this.paymentMethodRepositoryAdapter.findById(id)
                .map(paymentMethodMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Metodo de pagaento nao encontrado"));
    }

    @Override
    public List<PaymentMethodResponseDTO> getPaymentMethodByCompanyId(Long companyId) {
        this.companyRepositoryAdapter
                .findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("Empresa nao encontrada"));

        return this.paymentMethodRepositoryAdapter.findByCompanyId(companyId)
                .stream()
                .map(paymentMethodMapper::toResponseDTO)
                .toList();
    }

    @Override
    public PaymentMethodResponseDTO getPaymentMethodByUUID(UUID uuid) {
        return this.paymentMethodRepositoryAdapter.findByUuid(uuid)
                .map(paymentMethodMapper::toResponseDTO)
                .orElseThrow(() -> new NoSuchElementException("Metodo de pagaento nao encontrado"));
    }

    @Override
    public PaymentMethodResponseDTO createPaymentMethod(PaymentMethodCreateRequestDTO request) {
        CompanyModel companyModel = this.companyRepositoryAdapter
                .findById(request.getCompanyId()).orElseThrow(() -> new NoSuchElementException("Empresa nao encontrada"));

        Optional<PaymentMethodModel> paymentMethodModel = this.paymentMethodRepositoryAdapter.findByNameAndCompanyId(request.getName(), companyModel.getId());

        if (paymentMethodModel.isPresent()) {
            throw new EntityExistsException("Ja existe um metodo de pagamento com esse nome!");
        }

        PaymentMethodModel paymentMethod = new PaymentMethodModel();

        paymentMethod.setName(request.getName());
        paymentMethod.setCompany(companyModel);

        return paymentMethodMapper.toResponseDTO(this.paymentMethodRepositoryAdapter.save(paymentMethod));
    }

    @Override
    public PaymentMethodResponseDTO updatePaymentMethod(Long id, PaymentMethodUpdateRequestDTO request) {
        PaymentMethodModel paymentMethodModel = this.paymentMethodRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Metodo de pagamento nao encontrado"));

        if (!request.getName().equals(paymentMethodModel.getName())) {
            Optional<PaymentMethodModel> paymentMethodModelOptional = this.paymentMethodRepositoryAdapter
                    .findByNameAndCompanyId(request.getName(), paymentMethodModel.getCompany().getId());

            if (paymentMethodModelOptional.isPresent()) {
                throw new EntityExistsException("Ja existe um metodo de pagamento com esse nome!");
            }
        }

        paymentMethodModel.setName(request.getName());

        return paymentMethodMapper.toResponseDTO(this.paymentMethodRepositoryAdapter.save(paymentMethodModel));
    }

    @Override
    public void deletePaymentMethod(Long id) {
        this.paymentMethodRepositoryAdapter.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Metodo de pagamento nao encontrado"));

        this.paymentMethodRepositoryAdapter.delete(id);
    }
}
