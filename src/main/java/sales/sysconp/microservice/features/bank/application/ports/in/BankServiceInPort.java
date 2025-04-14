package sales.sysconp.microservice.features.bank.application.ports.in;

import sales.sysconp.microservice.features.bank.application.dto.BankCreateRequestDTO;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.application.dto.BankUpdateRequestDTO;

import java.util.Optional;
import java.util.UUID;

public interface BankServiceInPort {
    BankResponseDTO getBankById(Long id);

    BankResponseDTO getBankByUuid(UUID uuid);

    BankResponseDTO getBankByAcronym(String acronym, Long companyId);

    BankResponseDTO getBankByName(String name, Long companyId);

    BankResponseDTO getBankByAccountHolder(String accountHolder, Long companyId);

    BankResponseDTO getBankByAccountNumber(String accountNumber, Long companyId);

    BankResponseDTO getBankByIban(String iban, Long companyId);

    BankResponseDTO createBank(BankCreateRequestDTO bankCreateRequestDTO);

    BankResponseDTO updateBank(Long id, BankUpdateRequestDTO bankUpdateRequestDTO);

    void deleteBank(Long id);
}