package sales.sysconp.microservice.config.root.transationals.sale.application.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentCreateRequestDTO;
import sales.sysconp.microservice.features.installment.application.dto.InstallmentCreatedResponseDTO;
import sales.sysconp.microservice.features.installment.application.services.InstallmentService;
import sales.sysconp.microservice.features.payment_configuration.application.services.PaymentConfigurationService;
import sales.sysconp.microservice.features.sale.application.dto.SaleResponseDTO;
import sales.sysconp.microservice.features.sale.application.services.SaleService;
import sales.sysconp.microservice.root.transationals.sale.application.dto.CreateSaleWithInstallmentCreateRequestDTO;
import sales.sysconp.microservice.root.transationals.sale.application.dto.CreateSaleWithInstallmentResponseDTO;
import sales.sysconp.microservice.root.transationals.sale.application.ports.in.CreateSaleWithInstallmentInPort;

@Service
public class CreateSaleWithInstallmentService implements CreateSaleWithInstallmentInPort {
    private final SaleService saleService;
    private final InstallmentService installmentService;
    private final PaymentConfigurationService paymentConfigurationService;

    public CreateSaleWithInstallmentService(SaleService saleService, InstallmentService installmentService, PaymentConfigurationService PaymentConfigurationService) {
        this.saleService = saleService;
        this.installmentService = installmentService;
        this.paymentConfigurationService = PaymentConfigurationService;
    }

    @Transactional
    @Override
    public CreateSaleWithInstallmentResponseDTO execute(CreateSaleWithInstallmentCreateRequestDTO createSaleWithInstallmentCreateRequestDTO) {
        // CREATE SALE
        SaleResponseDTO saleResponseDTO = this.saleService.createSale(createSaleWithInstallmentCreateRequestDTO.getSaleCreateRequestDTO());

        // CREATE PAYMENT CONFIGURATION
        createSaleWithInstallmentCreateRequestDTO.getPaymentConfigurationCreateRequestDTO().setSaleId(saleResponseDTO.getId());
        this.paymentConfigurationService.createPaymentConfiguration(createSaleWithInstallmentCreateRequestDTO.getPaymentConfigurationCreateRequestDTO());

        // CREATE INSTALLMENTS
        InstallmentCreateRequestDTO installmentCreateRequestDTO = new InstallmentCreateRequestDTO();
        installmentCreateRequestDTO.setSaleId(saleResponseDTO.getId());

        InstallmentCreatedResponseDTO installmentCreatedResponseDTO = this.installmentService.createInstallment(installmentCreateRequestDTO);

        return new CreateSaleWithInstallmentResponseDTO(
                installmentCreatedResponseDTO.getNumInstallments(),
                installmentCreatedResponseDTO.getLastInstallmentDate(),
                installmentCreatedResponseDTO.getInstallmentType(),
                installmentCreatedResponseDTO.getMonth(),
                installmentCreatedResponseDTO.getYear()
        );
    }
}
