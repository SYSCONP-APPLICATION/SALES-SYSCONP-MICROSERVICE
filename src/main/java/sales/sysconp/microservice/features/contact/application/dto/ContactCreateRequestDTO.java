package sales.sysconp.microservice.features.contact.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContactCreateRequestDTO {
    @NotBlank(message = "Value is required")
    private String value;

    @NotNull(message = "IsPrimary is required")
    private Boolean isPrimary;

    @NotNull(message = "ContactType ID is required")
    private Long contactTypeId;

    @NotNull(message = "Client ID is required")
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