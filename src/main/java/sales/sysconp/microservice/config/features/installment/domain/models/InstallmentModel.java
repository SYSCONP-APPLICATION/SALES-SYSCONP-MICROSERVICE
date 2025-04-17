package sales.sysconp.microservice.config.features.installment.domain.models;

import sales.sysconp.microservice.features.debt.domain.models.DebtModel;
import sales.sysconp.microservice.features.installment.domain.enums.InstallmentTypeEnum;
import sales.sysconp.microservice.features.installment.domain.enums.MonthEnum;
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
    private Double value;
    private Integer index;
    private Double discount;
    private String additionalInfo;
    private LocalDateTime paidAt;
    private MonthEnum month;
    private int year;
    private InstallmentTypeEnum type;
    private SaleModel sale;
    private List<PaymentModel> payments;
    private DebtModel debt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public InstallmentModel() {
    }

    public InstallmentModel(Long id, UUID uuid, Double amount, LocalDateTime paymentDate, Double value, Integer index, Double discount, String additionalInfo, LocalDateTime paidAt, MonthEnum month, int year, InstallmentTypeEnum type, SaleModel sale, List<PaymentModel> payments, DebtModel debt, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.value = value;
        this.index = index;
        this.discount = discount;
        this.additionalInfo = additionalInfo;
        this.paidAt = paidAt;
        this.month = month;
        this.year = year;
        this.type = type;
        this.sale = sale;
        this.payments = payments;
        this.debt = debt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public MonthEnum getMonth() {
        return month;
    }

    public void setMonth(MonthEnum month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public InstallmentTypeEnum getType() {
        return type;
    }

    public void setType(InstallmentTypeEnum type) {
        this.type = type;
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}