package sales.sysconp.microservice.featuresd.contact.application.dto;

public class ContactUpdateRequestDTO {
    private String value;

    private Boolean isPrimary;

    private Long contactTypeId;

    public String getValue() {
        return value;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public Long getContactTypeId() {
        return contactTypeId;
    }
}