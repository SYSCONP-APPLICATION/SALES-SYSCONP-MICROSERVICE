package sales.sysconp.microservice.features.bank.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class BankCreateRequestDTO {
    @NotEmpty(message = "Acronym is required")
    private String acronym;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Account holder is required")
    private String accountHolder;

    @NotEmpty(message = "Account number is required")
    private String accountNumber;

    @NotEmpty(message = "IBAN is required")
    private String iban;

    @NotNull(message = "Company id is required")
    private Long companyId;

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getIban() {
        return iban;
    }

    public Long getCompanyId() {
        return companyId;
    }
}
