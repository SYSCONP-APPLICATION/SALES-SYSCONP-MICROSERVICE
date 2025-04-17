package sales.sysconp.microservice.config.features.client.domain.models;

import sales.sysconp.microservice.features.address.domain.models.AddressModel;
import sales.sysconp.microservice.features.contact.domain.models.ContactModel;
import sales.sysconp.microservice.features.sale.domain.models.SaleModel;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.project.property.domain.models.PropertyModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ClientModel {
    private Long id;
    private UUID uuid;
    private String name;
    private String identityCardNumber;
    private List<ContactModel> contacts;
    private List<SaleModel> sales;
    private AddressModel address;
    private CompanyModel company;
    private List<PropertyModel> properties;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public ClientModel() {
    }

    public ClientModel(Long id, UUID uuid, String name, AddressModel address, String identityCardNumber, List<ContactModel> contacts, List<SaleModel> sales, CompanyModel company, List<PropertyModel> properties, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.identityCardNumber = identityCardNumber;
        this.contacts = contacts;
        this.sales = sales;
        this.company = company;
        this.address = address;
        this.properties = properties;
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

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public List<ContactModel> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactModel> contacts) {
        this.contacts = contacts;
    }

    public List<SaleModel> getSales() {
        return sales;
    }

    public void setSales(List<SaleModel> sales) {
        this.sales = sales;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }

    public List<PropertyModel> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyModel> properties) {
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

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
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
