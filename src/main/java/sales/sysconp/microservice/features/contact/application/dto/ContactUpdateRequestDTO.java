package sales.sysconp.microservice.features.contact.application.dto;

public class ContactUpdateRequestDTO {
    private String value;

    private Boolean isPrimary;

    private Long contactTypeId;

    private Long clientId;

    public String getValue() {
        return value;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public Long getContactTypeId() {
        return contactTypeId;
    }

    public Long getClientId() {
        return clientId;
    }
}