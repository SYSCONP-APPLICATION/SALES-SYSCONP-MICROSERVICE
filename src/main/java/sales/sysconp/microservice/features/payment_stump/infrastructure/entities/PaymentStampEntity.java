package sales.sysconp.microservice.features.payment_stump.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.entities.PaymentConfigurationEntity;
import sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities.SystemPaymentConfigurationEntity;

@Entity
@Table(name = "payment_stamp")
public class PaymentStampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @PrePersist
    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }
    
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "paymentStamp")
    private List<PaymentConfigurationEntity> paymentConfigurations;

    @OneToMany(mappedBy = "paymentStamp")
    private List<SystemPaymentConfigurationEntity> systemPaymentConfigurations;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public PaymentStampEntity() {
    }

    public PaymentStampEntity(Long id, UUID uuid, String name, List<PaymentConfigurationEntity> paymentConfigurations, List<SystemPaymentConfigurationEntity> systemPaymentConfigurations, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public List<PaymentConfigurationEntity> getPaymentConfigurations() {
        return paymentConfigurations;
    }

    public void setPaymentConfigurations(List<PaymentConfigurationEntity> paymentConfigurations) {
        this.paymentConfigurations = paymentConfigurations;
    }

    public List<SystemPaymentConfigurationEntity> getSystemPaymentConfigurations() {
        return systemPaymentConfigurations;
    }

    public void setSystemPaymentConfigurations(List<SystemPaymentConfigurationEntity> systemPaymentConfigurations) {
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
