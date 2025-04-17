package sales.sysconp.microservice.config.features.bank.domain.models;

import sales.sysconp.microservice.features.payment.domain.models.PaymentModel;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BankModel {
    private Long id;
    private UUID uuid;
    private String acronym;
    private String name;
    private String accountHolder;
    private String accountNumber;
    private String iban;
    private List<PaymentModel> payments;
    private CompanyModel company;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public BankModel() {
    }

    public BankModel(Long id, UUID uuid, String acronym, String name, String accountHolder, String accountNumber, String iban, List<PaymentModel> payments, CompanyModel company, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.acronym = acronym;
        this.name = name;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.iban = iban;
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

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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