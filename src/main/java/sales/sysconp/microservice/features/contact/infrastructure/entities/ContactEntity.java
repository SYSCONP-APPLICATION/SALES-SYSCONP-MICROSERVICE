package sales.sysconp.microservice.features.contact.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.features.contact_type.infrastructure.entities.ContactTypeEntity;

@Entity
@Table(name = "contacts")
public class ContactEntity {
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
    private String value;

    @Column(nullable = false)
    private Boolean isPrimary = false;

    @ManyToOne
    @JoinColumn(name = "contactTypeId", referencedColumnName = "id")
    private ContactTypeEntity contactType;

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    private ClientEntity client;

    @Column(updatable = false)  
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)  
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public ContactEntity() {
    }

    public ContactEntity(Long id, UUID uuid, String value, Boolean isPrimary, ContactTypeEntity contactType, ClientEntity client, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.value = value;
        this.isPrimary = isPrimary;
        this.contactType = contactType;
        this.client = client;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public ContactTypeEntity getContactType() {
        return contactType;
    }

    public void setContactType(ContactTypeEntity contactType) {
        this.contactType = contactType;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
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
