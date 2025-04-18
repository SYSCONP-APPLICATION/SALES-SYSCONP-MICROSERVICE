package sales.sysconp.microservice.features.payment.application.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import sales.sysconp.microservice.features.payment.domain.enums.PaymentProcessEnum;

public class PaymentCreateRequestDTO {
    @NotNull(message = "Value must not be null")
    private Double value;

    @NotNull(message = "Payment method ID must not be null")
    @Positive(message = "Payment method ID must be a positive number")
    private Long paymentMethodId;

    @NotNull(message = "Sale ID must not be null")
    @Positive(message = "Sale ID must be a positive number")
    private Long saleId;

    @NotNull(message = "Installment ID must not be null")
    @Positive(message = "Installment ID must be a positive number")
    private Long installmentId;
    
    @NotNull(message = "Bank ID must not be null")
    @Positive(message = "Bank ID must be a positive number")
    private Long bankId;

    @NotNull(message = "Transaction code must not be null")
    private String transactionCode;

    @NotNull(message = "Company ID must not be null")
    @Positive(message = "Company ID must be a positive number")
    private Long companyId;

    @NotNull(message = "User ID must not be null")
    @Positive(message = "User ID must be a positive number")
    private Long userId;

    @NotNull(message = "Payment process must not be null")
    @Enumerated(EnumType.STRING)
    private PaymentProcessEnum paymentProcess;

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public Long getSaleId() {
        return saleId;
    }

    public Long getInstallmentId() {
        return installmentId;
    }

    public Long getBankId() {
        return bankId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public Long getUserId() {
        return userId;
    }

    public PaymentProcessEnum getPaymentProcess() {
        return paymentProcess;
    }

    public Double getValue() {
        return value;
    }
}