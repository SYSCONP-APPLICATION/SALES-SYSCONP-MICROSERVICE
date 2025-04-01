package sales.sysconp.microservice.features.client.domain.models;

import sales.sysconp.microservice.features.contact.infrastructure.entities.ContactEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ClientModel {
    private Long id;
    private UUID uuid;
    private String name;
    private String identityCardNumber;
    private List<ContactEntity> contacts;
    private List<SaleEntity> sales;
    private CompanyEntity company;
    private List<PropertyEntity> properties;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClientModel() {
    }

    public ClientModel(Long id, UUID uuid, String name, String identityCardNumber, List<ContactEntity> contacts, List<SaleEntity> sales, CompanyEntity company, List<PropertyEntity> properties, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.identityCardNumber = identityCardNumber;
        this.contacts = contacts;
        this.sales = sales;
        this.company = company;
        this.properties = properties;
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

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public List<ContactEntity> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }

    public List<SaleEntity> getSales() {
        return sales;
    }

    public void setSales(List<SaleEntity> sales) {
        this.sales = sales;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyEntity> properties) {
        this.properties = properties;
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
