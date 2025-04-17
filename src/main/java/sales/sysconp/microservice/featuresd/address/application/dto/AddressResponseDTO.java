package sales.sysconp.microservice.featuresd.address.application.dto;

import sales.sysconp.microservice.features.client.domain.models.ClientModel;
import java.time.LocalDateTime;
import java.util.UUID;

public class AddressResponseDTO {
    private Long id;
    private UUID uuid;
    private ClientModel client;
    private String country;
    private String province;
    private String municipality;
    private String city;
    private String neighborhood;
    private String street;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AddressResponseDTO() {
    }

    public AddressResponseDTO(Long id, UUID uuid, ClientModel client, String country, String province, String municipality, String city, String neighborhood, String street, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.client = client;
        this.country = country;
        this.province = province;
        this.municipality = municipality;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.description = description;
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

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
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
}
