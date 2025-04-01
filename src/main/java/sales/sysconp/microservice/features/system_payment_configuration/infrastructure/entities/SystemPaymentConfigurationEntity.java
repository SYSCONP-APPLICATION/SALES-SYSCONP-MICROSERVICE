package sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.payment_stump.infrastructure.entities.PaymentStampEntity;
// import sales.sysconp.microservice.features.payment_stamp.infrastructure.entities.PaymentStampEntity;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "payment_configurations")
public class SystemPaymentConfigurationEntity {
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

    @Column(nullable = false)
    private boolean requireOnCreateSale;

    @Column(nullable = false)
    private boolean requireForAllSales;

    @ManyToOne
    @JoinColumn(name = "payment_stamp_id", nullable = false)
    private PaymentStampEntity paymentStamp;

    @OneToOne(mappedBy = "systemPaymentConfiguration", cascade = CascadeType.ALL)
    private CompanyEntity company;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public SystemPaymentConfigurationEntity() {
    }

    public SystemPaymentConfigurationEntity(Long id, UUID uuid, Long dayOfMonth, boolean requireOnCreateSale, boolean requireForAllSales, PaymentStampEntity paymentStamp, CompanyEntity company, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.dayOfMonth = dayOfMonth;
        this.requireOnCreateSale = requireOnCreateSale;
        this.requireForAllSales = requireForAllSales;
        this.paymentStamp = paymentStamp;
        this.company = company;
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

    public boolean isRequireOnCreateSale() {
        return requireOnCreateSale;
    }

    public void setRequireOnCreateSale(boolean requireOnCreateSale) {
        this.requireOnCreateSale = requireOnCreateSale;
    }

    public boolean isRequireForAllSales() {
        return requireForAllSales;
    }

    public void setRequireForAllSales(boolean requireForAllSales) {
        this.requireForAllSales = requireForAllSales;
    }

    public PaymentStampEntity getPaymentStamp() {
        return paymentStamp;
    }

    public void setPaymentStamp(PaymentStampEntity paymentStamp) {
        this.paymentStamp = paymentStamp;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
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