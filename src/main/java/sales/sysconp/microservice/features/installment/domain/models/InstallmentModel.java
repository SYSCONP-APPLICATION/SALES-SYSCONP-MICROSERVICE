package sales.sysconp.microservice.features.installment.domain.models;

import sales.sysconp.microservice.features.debt.domain.models.DebtModel;
import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class InstallmentModel {
    private Long id;
    private UUID uuid;
    private Double amount;
    private LocalDateTime paymentDate;
    private LocalDateTime paidAt;
    private SaleModel sale;
    private List<PaymentModel> payments;
    private DebtModel debt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public InstallmentModel() {
    }

    public InstallmentModel(Long id, UUID uuid, Double amount, LocalDateTime paymentDate, LocalDateTime paidAt, SaleModel sale, List<PaymentModel> payments, DebtModel debt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paidAt = paidAt;
        this.sale = sale;
        this.payments = payments;
        this.debt = debt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public SaleModel getSale() {
        return sale;
    }

    public void setSale(SaleModel sale) {
        this.sale = sale;
    }

    public List<PaymentModel> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentModel> payments) {
        this.payments = payments;
    }

    public DebtModel getDebt() {
        return debt;
    }

    public void setDebt(DebtModel debt) {
        this.debt = debt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}