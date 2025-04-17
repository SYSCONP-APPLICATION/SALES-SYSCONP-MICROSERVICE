package sales.sysconp.microservice.featuresd.contact_type.application.dto;

import jakarta.validation.constraints.NotEmpty;

public class ContactTypeCreateRequestDTO {
    @NotEmpty(message = "Name is required")
    private String name;

    public String getName() {
        return name;
    }
}
