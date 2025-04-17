package sales.sysconp.microservice.featuresd.contact.application.dto;

import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import sales.sysconp.microservice.features.contact_type.domain.models.ContactTypeModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class ContactResponseDTO {
    private Long id;
    private UUID uuid;
    private String value;
    private Boolean isPrimary;
    private ContactTypeModel contactType;
    private ClientModel client;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ContactResponseDTO() {
    }

    public ContactResponseDTO(Long id, UUID uuid, String value, Boolean isPrimary, ContactTypeModel contactType, ClientModel client, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public ContactTypeModel getContactType() {
        return contactType;
    }

    public void setContactType(ContactTypeModel contactType) {
        this.contactType = contactType;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
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