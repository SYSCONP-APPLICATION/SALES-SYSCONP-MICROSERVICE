package sales.sysconp.microservice.config.features.payment_method.domain.models;

import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PaymentMethodModel {
    private Long id;
    private UUID uuid;
    private String name;
    private List<PaymentModel> payments;
    private CompanyModel company;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public PaymentMethodModel () {}

    public PaymentMethodModel(Long id, UUID uuid, String name, List<PaymentModel> payments, CompanyModel company, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.payments = payments;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PaymentModel> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentModel> payments) {
        this.payments = payments;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
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
