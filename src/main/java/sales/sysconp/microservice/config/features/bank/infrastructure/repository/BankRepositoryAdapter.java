package sales.sysconp.microservice.config.features.bank.infrastructure.repository;

import org.springframework.stereotype.Repository;
import sales.sysconp.microservice.features.bank.application.ports.out.BankRepositoryOutPort;
import sales.sysconp.microservice.features.bank.domain.mappers.BankMapper;
import sales.sysconp.microservice.features.bank.domain.models.BankModel;
import sales.sysconp.microservice.features.bank.infrastructure.repository.JPABankRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class BankRepositoryAdapter implements BankRepositoryOutPort {
    private final sales.sysconp.microservice.features.bank.infrastructure.repository.JPABankRepository jpaBankRepository;
    private final BankMapper bankMapper;

    public BankRepositoryAdapter(JPABankRepository jpaBankRepository, BankMapper bankMapper) {
        this.jpaBankRepository = jpaBankRepository;
        this.bankMapper = bankMapper;
    }

    @Override
    public BankModel findById(Long id) {
        return jpaBankRepository.findById(id).map(bankMapper::toModel).orElseThrow(() -> new NoSuchElementException("Bank not found with id: " + id));
    }

    @Override
    public Optional<BankModel> findByUuid(UUID uuid) {
        return jpaBankRepository.findByUuid(uuid).map(bankMapper::toModel);
    }

    @Override
    public List<BankModel> findByCompanyId(Long companyId) {
        return jpaBankRepository.findByCompanyId(companyId).stream()
                .map(bankMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BankModel> findByIdAndCompanyId(Long id, Long companyId) {
        return jpaBankRepository.findByIdAndCompanyId(id, companyId).map(bankMapper::toModel);
    }

    @Override
    public Optional<BankModel> findByAcronymAndCompanyId(String acronym, Long companyId) {
        return jpaBankRepository.findByAcronymAndCompanyId(acronym, companyId).map(bankMapper::toModel);
    }

    @Override
    public Optional<BankModel> findByNameAndCompanyId(String name, Long companyId) {
        return jpaBankRepository.findByNameAndCompanyId(name, companyId).map(bankMapper::toModel);
    }

    @Override
    public Optional<BankModel> findByAccountHolderAndCompanyId(String accountHolder, Long companyId) {
        return jpaBankRepository.findByAccountHolderAndCompanyId(accountHolder, companyId).map(bankMapper::toModel);
    }

    @Override
    public Optional<BankModel> findByAccountNumberAndCompanyId(String accountNumber, Long companyId) {
        return jpaBankRepository.findByAccountNumberAndCompanyId(accountNumber, companyId).map(bankMapper::toModel);
    }

    @Override
    public Optional<BankModel> findByIbanAndCompanyId(String iban, Long companyId) {
        return jpaBankRepository.findByIbanAndCompanyId(iban, companyId).map(bankMapper::toModel);
    }

    @Override
    public Optional<BankModel> findByAcronym(String acronym) {
        return jpaBankRepository.findByAcronym(acronym).map(bankMapper::toModel);
    }

    @Override
    public Optional<BankModel> findByName(String name) {
        return jpaBankRepository.findByName(name).map(bankMapper::toModel);
    }

    @Override
    public Optional<BankModel> findByAccountHolder(String accountHolder) {
        return jpaBankRepository.findByAccountHolder(accountHolder).map(bankMapper::toModel);
    }

    @Override
    public Optional<BankModel> findByAccountNumber(String accountNumber) {
        return jpaBankRepository.findByAccountNumber(accountNumber).map(bankMapper::toModel);
    }

    @Override
    public Optional<BankModel> findByIban(String iban) {
        return jpaBankRepository.findByIban(iban).map(bankMapper::toModel);
    }

    @Override
    public BankModel save(BankModel bankModel) {
        return bankMapper.toModel(jpaBankRepository.save(bankMapper.toEntity(bankModel)));
    }

    @Override
    public void delete(Long id) {
        jpaBankRepository.deleteById(id);
    }
}
