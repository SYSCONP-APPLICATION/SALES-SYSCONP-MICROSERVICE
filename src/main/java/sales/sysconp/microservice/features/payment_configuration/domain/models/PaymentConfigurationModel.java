package sales.sysconp.microservice.features.payment_configuration.domain.models;

import sales.sysconp.microservice.features.payment_stump.infrastructure.entities.PaymentStampEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentConfigurationModel {
    private Long id;
    private UUID uuid;
    private Long dayOfMonth;
    private SaleEntity sale;
    private PaymentStampEntity paymentStamp;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PaymentConfigurationModel() {
    }

    public PaymentConfigurationModel(Long id, UUID uuid, Long dayOfMonth, SaleEntity sale, PaymentStampEntity paymentStamp, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.dayOfMonth = dayOfMonth;
        this.sale = sale;
        this.paymentStamp = paymentStamp;
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

    public Long getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Long dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public SaleEntity getSale() {
        return sale;
    }

    public void setSale(SaleEntity sale) {
        this.sale = sale;
    }

    public PaymentStampEntity getPaymentStamp() {
        return paymentStamp;
    }

    public void setPaymentStamp(PaymentStampEntity paymentStamp) {
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
}