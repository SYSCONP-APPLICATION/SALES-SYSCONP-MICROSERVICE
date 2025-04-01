package sales.sysconp.microservice.features.contact_type.domain.models;

import sales.sysconp.microservice.features.contact.domain.models.ContactModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ContactTypeModel {
    private Long id;
    private UUID uuid;
    private String name;
    private List<ContactModel> contacts;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public ContactTypeModel() {
    }

    public ContactTypeModel(Long id, UUID uuid, String name, List<ContactModel> contacts, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.contacts = contacts;
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

    public List<ContactModel> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactModel> contacts) {
        this.contacts = contacts;
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