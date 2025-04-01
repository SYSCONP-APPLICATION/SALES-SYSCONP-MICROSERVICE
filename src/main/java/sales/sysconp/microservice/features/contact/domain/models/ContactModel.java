package sales.sysconp.microservice.features.contact.domain.models;

import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;
import sales.sysconp.microservice.features.contact_type.infrastructure.entities.ContactTypeEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class ContactModel {
    private Long id;
    private UUID uuid;
    private String value;
    private Boolean isPrimary;
    private ContactTypeEntity contactType;
    private ClientEntity client;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ContactModel() {
    }

    public ContactModel(Long id, UUID uuid, String value, Boolean isPrimary, ContactTypeEntity contactType, ClientEntity client, LocalDateTime createdAt, LocalDateTime updatedAt) {
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