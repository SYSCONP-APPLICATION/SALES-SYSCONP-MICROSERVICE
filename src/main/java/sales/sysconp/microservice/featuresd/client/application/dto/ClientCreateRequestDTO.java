package sales.sysconp.microservice.featuresd.client.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClientCreateRequestDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Identity card number is mandatory")
    private String identityCardNumber;

    @NotNull(message = "companyId is mandatory")
    private Long companyId;

    public String getName() {
        return name;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }
}