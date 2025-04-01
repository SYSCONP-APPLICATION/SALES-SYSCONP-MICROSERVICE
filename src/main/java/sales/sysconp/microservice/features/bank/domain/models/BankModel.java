package sales.sysconp.microservice.features.bank.domain.models;

import sales.sysconp.microservice.features.payment.infrastructure.entities.PaymentEntity;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;

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
    private List<PaymentEntity> payments;
    private CompanyEntity company;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BankModel() {
    }

    public BankModel(Long id, UUID uuid, String acronym, String name, String accountHolder, String accountNumber, String iban, List<PaymentEntity> payments, CompanyEntity company, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentEntity> payments) {
        this.payments = payments;
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