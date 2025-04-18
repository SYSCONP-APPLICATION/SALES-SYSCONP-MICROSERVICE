package sales.sysconp.microservice.features.address.application.dto;

public class AddressUpdateRequestDTO {
    private String country;

    private String province;

    private String municipality;

    private String city;

    private String neighborhood;

    private String street;

    private String description;

    private String postalCode;

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public String getDescription() {
        return description;
    }

    public String getPostalCode() {
        return postalCode;
    }
}