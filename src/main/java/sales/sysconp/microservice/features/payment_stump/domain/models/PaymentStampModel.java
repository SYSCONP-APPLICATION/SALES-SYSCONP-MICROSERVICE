package sales.sysconp.microservice.features.payment_stump.domain.models;

import sales.sysconp.microservice.features.payment_configuration.domain.models.PaymentConfigurationModel;
import sales.sysconp.microservice.features.system_payment_configuration.domain.models.SystemPaymentConfigurationModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PaymentStampModel {
    private Long id;
    private UUID uuid;
    private String name;
    private List<PaymentConfigurationModel> paymentConfigurations;
    private List<SystemPaymentConfigurationModel> systemPaymentConfigurations;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PaymentStampModel() {
    }

    public PaymentStampModel(Long id, UUID uuid, String name, List<PaymentConfigurationModel> paymentConfigurations, List<SystemPaymentConfigurationModel> systemPaymentConfigurations, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.paymentConfigurations = paymentConfigurations;
        this.systemPaymentConfigurations = systemPaymentConfigurations;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PaymentConfigurationModel> getPaymentConfigurations() {
        return paymentConfigurations;
    }

    public void setPaymentConfigurations(List<PaymentConfigurationModel> paymentConfigurations) {
        this.paymentConfigurations = paymentConfigurations;
    }

    public List<SystemPaymentConfigurationModel> getSystemPaymentConfigurations() {
        return systemPaymentConfigurations;
    }

    public void setSystemPaymentConfigurations(List<SystemPaymentConfigurationModel> systemPaymentConfigurations) {
        this.systemPaymentConfigurations = systemPaymentConfigurations;
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