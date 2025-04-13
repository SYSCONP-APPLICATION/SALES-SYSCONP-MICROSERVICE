package sales.sysconp.microservice.features.address.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddressCreateRequestDTO {
    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Province is required")
    private String province;

    @NotBlank(message = "Municipality is required")
    private String municipality;

    @NotBlank(message = "City is required")
    private String city;

    private String neighborhood;

    private String street;

    private String description;

    @NotNull(message = "Client Id is required")
    private Long clientId;

    public AddressCreateRequestDTO() {
    }

    public Long getClientId() {
        return clientId;
    }

    public String getDescription() {
        return description;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }
}
