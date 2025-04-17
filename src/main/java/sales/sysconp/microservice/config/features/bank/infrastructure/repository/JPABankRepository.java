package sales.sysconp.microservice.config.features.bank.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.sysconp.microservice.features.bank.infrastructure.entities.BankEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JPABankRepository extends JpaRepository<BankEntity, Long> {
    Optional<BankEntity> findByUuid(UUID uuid);

    List<BankEntity> findByCompanyId(Long companyId);

    Optional<BankEntity> findByIdAndCompanyId(Long id, Long companyId);

    Optional<BankEntity> findByAcronymAndCompanyId(String acronym, Long companyId);

    Optional<BankEntity> findByAccountHolderAndCompanyId(String accountHolder, Long companyId);

    Optional<BankEntity> findByAccountNumberAndCompanyId(String accountNumber, Long companyId);

    Optional<BankEntity> findByNameAndCompanyId(String name, Long companyId);

    Optional<BankEntity> findByIbanAndCompanyId(String iban, Long companyId);

    Optional<BankEntity> findByAcronym(String acronym);

    Optional<BankEntity> findByName(String name);

    Optional<BankEntity> findByAccountHolder(String accountHolder);

    Optional<BankEntity> findByAccountNumber(String accountNumber);

    Optional<BankEntity> findByIban(String iban);
}
