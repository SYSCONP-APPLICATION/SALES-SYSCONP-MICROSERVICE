package sales.sysconp.microservice.features.payment_configuration.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.payment_stump.infrastructure.entities.PaymentStampEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "payment_configurations")
public class PaymentConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }
    
    @Column(nullable = false)
    private Long dayOfMonth;
    
    @OneToOne(mappedBy = "paymentConfiguration")
    private SaleEntity sale;

    @ManyToOne
    @JoinColumn(name = "payment_stamp_id", nullable = false)
    private PaymentStampEntity paymentStamp;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column()
    private LocalDateTime deletedAt;

    public PaymentConfigurationEntity() {
    }

    public PaymentConfigurationEntity(Long id, UUID uuid, Long dayOfMonth, SaleEntity sale, PaymentStampEntity paymentStamp, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}