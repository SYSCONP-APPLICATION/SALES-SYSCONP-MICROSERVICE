package sales.sysconp.microservice.config.features.bank.application.ports.out;

import sales.sysconp.microservice.features.bank.domain.models.BankModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BankRepositoryOutPort {
    BankModel findById(Long id);

    Optional<BankModel> findByUuid(UUID uuid);

    List<BankModel> findByCompanyId(Long companyId);

    Optional<BankModel> findByIdAndCompanyId(Long id, Long companyId);

    Optional<BankModel> findByAcronymAndCompanyId(String acronym, Long companyId);

    Optional<BankModel> findByNameAndCompanyId(String name, Long companyId);

    Optional<BankModel> findByAccountHolderAndCompanyId(String accountHolder, Long companyId);

    Optional<BankModel> findByAccountNumberAndCompanyId(String accountNumber, Long companyId);

    Optional<BankModel> findByIbanAndCompanyId(String iban, Long companyId);

    Optional<BankModel> findByAcronym(String acronym);

    Optional<BankModel> findByName(String name);

    Optional<BankModel> findByAccountHolder(String accountHolder);

    Optional<BankModel> findByAccountNumber(String accountNumber);

    Optional<BankModel> findByIban(String iban);

    BankModel save(BankModel bankModel);

    void delete(Long id);
}