package sales.sysconp.microservice.features.sale.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.features.installment.infrastructure.entities.InstallmentEntity;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.payment_configuration.infrastructure.entities.PaymentConfigurationEntity;
import sales.sysconp.microservice.features.sale.domain.enums.SaleStatus;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;

@Entity
@Table(name = "sales")
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @PrePersist
    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }
    
    @Column(nullable = false)
    private SaleStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private UserEntity user;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<PaymentEntity> payments;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<InstallmentEntity> installments;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_configuration_id", referencedColumnName = "id")
    private PaymentConfigurationEntity paymentConfiguration;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column()
    private LocalDateTime deletedAt;

    public SaleEntity() {
    }

    public SaleEntity(Long id, UUID uuid, SaleStatus status, ClientEntity client, UserEntity user, List<PaymentEntity> payments, List<InstallmentEntity> installments, PaymentConfigurationEntity paymentConfiguration, CompanyEntity company, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.status = status;
        this.client = client;
        this.user = user;
        this.payments = payments;
        this.installments = installments;
        this.paymentConfiguration = paymentConfiguration;
        this.company = company;
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

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentEntity> payments) {
        this.payments = payments;
    }

    public List<InstallmentEntity> getInstallments() {
        return installments;
    }

    public void setInstallments(List<InstallmentEntity> installments) {
        this.installments = installments;
    }

    public PaymentConfigurationEntity getPaymentConfiguration() {
        return paymentConfiguration;
    }

    public void setPaymentConfiguration(PaymentConfigurationEntity paymentConfiguration) {
        this.paymentConfiguration = paymentConfiguration;
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}