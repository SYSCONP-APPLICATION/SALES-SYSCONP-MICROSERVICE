package sales.sysconp.microservice.features.bank.application.dto;

import jakarta.validation.constraints.NotNull;

public class BankUpdateRequestDTO {
    private String acronym;

    private String name;

    private String accountHolder;

    private String accountNumber;

    private String iban;

    @NotNull(message = "companyId is required")
    private Long companyId;

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

    public Long getCompanyId() {
        return companyId;
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
}
