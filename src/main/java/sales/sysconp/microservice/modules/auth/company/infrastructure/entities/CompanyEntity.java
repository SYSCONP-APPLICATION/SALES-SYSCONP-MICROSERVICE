package sales.sysconp.microservice.modules.auth.company.infrastructure.entities;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.bank.infrastructure.entities.BankEntity;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.payment_method.infrastructure.entities.PaymentMethodEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities.SystemPaymentConfigurationEntity;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;

@Entity
@Table(name = "companies")
public class CompanyEntity {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;
    
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<UserEntity> users;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<BankEntity> banks;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<ClientEntity> clients;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<PaymentEntity> payments;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<PaymentMethodEntity> paymentMethods;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<SaleEntity> sales;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<ProjectEntity> projects;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "system_payment_configuration_id", referencedColumnName = "id")
    private SystemPaymentConfigurationEntity systemPaymentConfiguration;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;

    public CompanyEntity() { }

    public CompanyEntity(Long id, UUID uuid, List<UserEntity> users, List<BankEntity> banks, List<ClientEntity> clients, List<PaymentEntity> payments, List<PaymentMethodEntity> paymentMethods, List<SaleEntity> sales, List<ProjectEntity> projects, SystemPaymentConfigurationEntity systemPaymentConfiguration, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.users = users;
        this.banks = banks;
        this.clients = clients;
        this.payments = payments;
        this.paymentMethods = paymentMethods;
        this.sales = sales;
        this.projects = projects;
        this.systemPaymentConfiguration = systemPaymentConfiguration;
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

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public List<BankEntity> getBanks() {
        return banks;
    }

    public void setBanks(List<BankEntity> banks) {
        this.banks = banks;
    }

    public List<ClientEntity> getClients() {
        return clients;
    }

    public void setClients(List<ClientEntity> clients) {
        this.clients = clients;
    }

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentEntity> payments) {
        this.payments = payments;
    }

    public List<PaymentMethodEntity> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethodEntity> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<SaleEntity> getSales() {
        return sales;
    }

    public void setSales(List<SaleEntity> sales) {
        this.sales = sales;
    }

    public List<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }

    public SystemPaymentConfigurationEntity getSystemPaymentConfiguration() {
        return systemPaymentConfiguration;
    }

    public void setSystemPaymentConfiguration(SystemPaymentConfigurationEntity systemPaymentConfiguration) {
        this.systemPaymentConfiguration = systemPaymentConfiguration;
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