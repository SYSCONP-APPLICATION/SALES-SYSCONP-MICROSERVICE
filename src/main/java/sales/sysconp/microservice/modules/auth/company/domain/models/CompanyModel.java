package sales.sysconp.microservice.modules.auth.company.domain.models;

import sales.sysconp.microservice.features.bank.domain.models.BankModel;
import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;
import sales.sysconp.microservice.features.payment_method.domain.models.PaymentMethodModel;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.features.system_payment_configuration.domain.models.SystemPaymentConfigurationModel;
import sales.sysconp.microservice.modules.auth.user.domain.models.UserModel;
import sales.sysconp.microservice.modules.project.project.domain.models.ProjectModel;
import sales.sysconp.microservice.modules.project.property_category.domain.models.PropertyCategoryModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CompanyModel {
    private Long id;
    private UUID uuid;
    private List<UserModel> users;
    private List<BankModel> banks;
    private List<ClientModel> clients;
    private List<PaymentModel> payments;
    private List<PaymentMethodModel> paymentMethods;
    private List<SaleModel> sales;
    private List<ProjectModel> projects;
    private SystemPaymentConfigurationModel systemPaymentConfiguration;
    private List<PropertyCategoryModel> propertyCategories;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public CompanyModel() {
    }

    public CompanyModel(Long id, UUID uuid, List<UserModel> users, List<BankModel> banks, List<ClientModel> clients, List<PaymentModel> payments, List<PaymentMethodModel> paymentMethods, List<SaleModel> sales, List<ProjectModel> projects, SystemPaymentConfigurationModel systemPaymentConfiguration, List<PropertyCategoryModel> propertyCategories, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
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
        this.propertyCategories = propertyCategories;
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

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public List<BankModel> getBanks() {
        return banks;
    }

    public void setBanks(List<BankModel> banks) {
        this.banks = banks;
    }

    public List<ClientModel> getClients() {
        return clients;
    }

    public void setClients(List<ClientModel> clients) {
        this.clients = clients;
    }

    public List<PaymentModel> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentModel> payments) {
        this.payments = payments;
    }

    public List<PaymentMethodModel> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethodModel> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<SaleModel> getSales() {
        return sales;
    }

    public void setSales(List<SaleModel> sales) {
        this.sales = sales;
    }

    public List<ProjectModel> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectModel> projects) {
        this.projects = projects;
    }

    public SystemPaymentConfigurationModel getSystemPaymentConfiguration() {
        return systemPaymentConfiguration;
    }

    public void setSystemPaymentConfiguration(SystemPaymentConfigurationModel systemPaymentConfiguration) {
        this.systemPaymentConfiguration = systemPaymentConfiguration;
    }

    public List<PropertyCategoryModel> getPropertyCategories() {
        return propertyCategories;
    }

    public void setPropertyCategories(List<PropertyCategoryModel> propertyCategories) {
        this.propertyCategories = propertyCategories;
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
