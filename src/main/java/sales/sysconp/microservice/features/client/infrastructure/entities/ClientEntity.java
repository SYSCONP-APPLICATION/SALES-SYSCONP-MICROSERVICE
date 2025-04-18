package sales.sysconp.microservice.features.client.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import sales.sysconp.microservice.features.address.infrastructure.entities.AddressEntity;
import sales.sysconp.microservice.features.contact.infrastructure.entities.ContactEntity;
import sales.sysconp.microservice.features.sale.infrastructure.entities.SaleEntity;
import sales.sysconp.microservice.modules.auth.company.infrastructure.entities.CompanyEntity;
import sales.sysconp.microservice.modules.project.property.infrastructure.entities.PropertyEntity;

@Entity
@Table(name = "clients")
@SQLDelete(sql = "UPDATE clients SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;
    
    @PrePersist
    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }

    @Column(unique = false, nullable = false)
    private String name;
    
    @Column(unique = false, nullable = false)
    private String identityCardNumber;
    
    @OneToMany(mappedBy = "client")
    private List<ContactEntity> contacts;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<SaleEntity> sales;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private AddressEntity address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<PropertyEntity> properties;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column()
    private LocalDateTime deletedAt;

    public ClientEntity() {
    }

    public ClientEntity(Long id, UUID uuid, String name, String identityCardNumber, AddressEntity address, List<ContactEntity> contacts, List<SaleEntity> sales, CompanyEntity company, List<PropertyEntity> properties, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public AddressEntity getAddress() { return address; }

    public void setAddress(AddressEntity address) { this.address = address; }
}
