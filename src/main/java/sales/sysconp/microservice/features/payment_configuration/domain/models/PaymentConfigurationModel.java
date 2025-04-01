package sales.sysconp.microservice.features.payment_configuration.domain.models;

import sales.sysconp.microservice.features.payment_stump.domain.models.PaymentStampModel;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentConfigurationModel {
    private Long id;
    private UUID uuid;
    private Long dayOfMonth;
    private SaleModel sale;
    private PaymentStampModel paymentStamp;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public PaymentConfigurationModel() {
    }

    public PaymentConfigurationModel(Long id, UUID uuid, Long dayOfMonth, SaleModel sale, PaymentStampModel paymentStamp, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.dayOfMonth = dayOfMonth;
        this.sale = sale;
        this.paymentStamp = paymentStamp;
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

    public Long getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Long dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public SaleModel getSale() {
        return sale;
    }

    public void setSale(SaleModel sale) {
        this.sale = sale;
    }

    public PaymentStampModel getPaymentStamp() {
        return paymentStamp;
    }

    public void setPaymentStamp(PaymentStampModel paymentStamp) {
        this.paymentStamp = paymentStamp;
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