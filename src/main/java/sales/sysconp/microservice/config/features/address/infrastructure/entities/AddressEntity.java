package sales.sysconp.microservice.config.features.address.infrastructure.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;
import sales.sysconp.microservice.features.client.infrastructure.entities.ClientEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "addresses")
@SQLDelete(sql = "UPDATE addresses SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @PrePersist()
    public void generateUUID () {
        this.uuid = UUID.randomUUID();
    }

    @OneToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private String municipality;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = true)
    private String neighborhood;

    @Column(nullable = true)
    private String street;

    @Column(nullable = true)
    private String description;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column()
    private LocalDateTime deletedAt;

    public AddressEntity() {}

    public AddressEntity(Long id, UUID uuid, ClientEntity client, String postalCode, String country, String province, String municipality, String city, String neighborhood, String street, String description, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.client = client;
        this.country = country;
        this.postalCode = postalCode;
        this.province = province;
        this.municipality = municipality;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.description = description;
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

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
