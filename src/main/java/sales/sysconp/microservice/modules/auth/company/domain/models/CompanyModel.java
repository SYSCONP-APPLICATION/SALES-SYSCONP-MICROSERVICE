package sales.sysconp.microservice.modules.auth.company.domain.models;

import sales.sysconp.microservice.features.bank.infrastructure.entities.BankEntity;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.features.payment_method.infrastructure.entities.PaymentMethodEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.features.system_payment_configuration.infrastructure.entities.SystemPaymentConfigurationEntity;
import sales.sysconp.microservice.modules.auth.user.infrastructure.entities.UserEntity;
import sales.sysconp.microservice.modules.project.project.infrastructure.entities.ProjectEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CompanyModel {
    private Long id;
    private UUID uuid;
    private List<UserEntity> users;
    private List<BankEntity> banks;
    private List<ClientEntity> clients;
    private List<PaymentEntity> payments;
    private List<PaymentMethodEntity> paymentMethods;
    private List<SaleEntity> sales;
    private List<ProjectEntity> projects;
    private SystemPaymentConfigurationEntity systemPaymentConfiguration;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CompanyModel() {}

    public CompanyModel(Long id, UUID uuid, List<UserEntity> users, List<BankEntity> banks, List<ClientEntity> clients, List<PaymentEntity> payments, List<PaymentMethodEntity> paymentMethods, List<SaleEntity> sales, List<ProjectEntity> projects, SystemPaymentConfigurationEntity systemPaymentConfiguration, LocalDateTime createdAt, LocalDateTime updatedAt) {
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
