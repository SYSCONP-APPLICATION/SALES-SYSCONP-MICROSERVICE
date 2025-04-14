package sales.sysconp.microservice.features.bank.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sales.sysconp.microservice.features.bank.application.dto.BankCreateRequestDTO;
import sales.sysconp.microservice.features.bank.application.dto.BankResponseDTO;
import sales.sysconp.microservice.features.bank.application.dto.BankUpdateRequestDTO;
import sales.sysconp.microservice.features.bank.application.ports.in.BankServiceInPort;
import sales.sysconp.microservice.features.bank.domain.mappers.BankMapper;
import sales.sysconp.microservice.features.bank.domain.models.BankModel;
import sales.sysconp.microservice.features.bank.infrastructure.repository.BankRepositoryAdapter;
import sales.sysconp.microservice.modules.auth.company.domain.models.CompanyModel;
import sales.sysconp.microservice.modules.auth.company.infrastructure.repository.CompanyRepositoryAdapter;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankService implements BankServiceInPort {
    private final BankRepositoryAdapter bankRepositoryAdapter;
    private final CompanyRepositoryAdapter companyRepositoryAdapter;
    private final BankMapper bankMapper;

    @Override
    public BankResponseDTO getBankById(Long id) {
        BankModel bankModel = bankRepositoryAdapter.findById(id);

        if (bankModel == null) {
            throw new NoSuchElementException("Bank not found with id: " + id);
        }

        return bankMapper.toResponseDTO(bankModel);
    }

    @Override
    public BankResponseDTO getBankByUuid(UUID uuid) {
        return bankRepositoryAdapter.findByUuid(uuid)
                .map(bankMapper::toResponseDTO).orElseThrow(() -> new NoSuchElementException("Bank not found with uuid: " + uuid));
    }

    @Override
    public BankResponseDTO getBankByAcronym(String acronym, Long companyId) {
        this.companyRepositoryAdapter.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company not found with id: " + companyId));

        return bankRepositoryAdapter.findByAcronymAndCompanyId(acronym, companyId)
                .map(bankMapper::toResponseDTO).orElseThrow(() -> new NoSuchElementException("Bank not found with acronym: " + acronym));
    }

    @Override
    public BankResponseDTO getBankByName(String name, Long companyId) {
        this.companyRepositoryAdapter.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company not found with id: " + companyId));

        return bankRepositoryAdapter.findByNameAndCompanyId(name, companyId)
                .map(bankMapper::toResponseDTO).orElseThrow(() -> new NoSuchElementException("Bank not found with name: " + name));
    }

    @Override
    public BankResponseDTO getBankByAccountHolder(String accountHolder, Long companyId) {
        this.companyRepositoryAdapter.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company not found with id: " + companyId));

        return bankRepositoryAdapter.findByAccountHolderAndCompanyId(accountHolder, companyId)
                .map(bankMapper::toResponseDTO).orElseThrow(() -> new NoSuchElementException("Bank not found with account holder: " + accountHolder));
    }

    @Override
    public BankResponseDTO getBankByAccountNumber(String accountNumber, Long companyId) {
        this.companyRepositoryAdapter.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company not found with id: " + companyId));

        return bankRepositoryAdapter.findByAccountNumberAndCompanyId(accountNumber, companyId)
                .map(bankMapper::toResponseDTO).orElseThrow(() -> new NoSuchElementException("Bank not found with account number: " + accountNumber));
    }

    @Override
    public BankResponseDTO getBankByIban(String iban, Long companyId) {
        this.companyRepositoryAdapter.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company not found with id: " + companyId));

        return bankRepositoryAdapter.findByIbanAndCompanyId(iban, companyId)
                .map(bankMapper::toResponseDTO).orElseThrow(() -> new NoSuchElementException("Bank not found with iban: " + iban));
    }

    @Override
    public BankResponseDTO createBank(BankCreateRequestDTO bankCreateRequestDTO) {
        Optional<BankModel> bankModelByAccountHolder = this.bankRepositoryAdapter.findByAccountHolderAndCompanyId(bankCreateRequestDTO.getAccountHolder(), bankCreateRequestDTO.getCompanyId());

        if (bankModelByAccountHolder.isPresent()) {
            throw new IllegalArgumentException("Bank with account holder " + bankCreateRequestDTO.getAccountHolder() + " already exists");
        }

        Optional<BankModel> bankModelByAccountNumber = this.bankRepositoryAdapter.findByAccountNumberAndCompanyId(bankCreateRequestDTO.getAccountNumber(), bankCreateRequestDTO.getCompanyId());

        if (bankModelByAccountNumber.isPresent()) {
            throw new IllegalArgumentException("Bank with account number " + bankCreateRequestDTO.getAccountNumber() + " already exists");
        }

        Optional<BankModel> bankModelByIban = this.bankRepositoryAdapter.findByIbanAndCompanyId(bankCreateRequestDTO.getIban(), bankCreateRequestDTO.getCompanyId());

        if (bankModelByIban.isPresent()) {
            throw new IllegalArgumentException("Bank with iban " + bankCreateRequestDTO.getIban() + " already exists");
        }

        Optional<BankModel> bankModelByName = this.bankRepositoryAdapter.findByNameAndCompanyId(bankCreateRequestDTO.getName(), bankCreateRequestDTO.getCompanyId());

        if (bankModelByName.isPresent()) {
            throw new IllegalArgumentException("Bank with name " + bankCreateRequestDTO.getName() + " already exists");
        }

        Optional<BankModel> bankModelByAcronym = this.bankRepositoryAdapter.findByAcronymAndCompanyId(bankCreateRequestDTO.getAcronym(), bankCreateRequestDTO.getCompanyId());

        if (bankModelByAcronym.isPresent()) {
            throw new IllegalArgumentException("Bank with acronym " + bankCreateRequestDTO.getAcronym() + " already exists");
        }

        CompanyModel company = companyRepositoryAdapter.findById(bankCreateRequestDTO.getCompanyId())
                .orElseThrow(() -> new NoSuchElementException("Company not found with id: " + bankCreateRequestDTO.getCompanyId()));

        BankModel bank = new BankModel();

        bank.setAcronym(bankCreateRequestDTO.getAcronym());
        bank.setName(bankCreateRequestDTO.getName());
        bank.setAccountHolder(bankCreateRequestDTO.getAccountHolder());
        bank.setAccountNumber(bankCreateRequestDTO.getAccountNumber());
        bank.setIban(bankCreateRequestDTO.getIban());
        bank.setCompany(company);

        return bankMapper.toResponseDTO(bankRepositoryAdapter.save(bank));
    }

    @Override
    public BankResponseDTO updateBank(Long id, BankUpdateRequestDTO bankUpdateRequestDTO) {
        BankModel bankModel = bankRepositoryAdapter.findByIdAndCompanyId(id, bankUpdateRequestDTO.getCompanyId()).orElseThrow(() -> new NoSuchElementException("Bank not found with id: " + id));

        if (bankUpdateRequestDTO.getAcronym() != null && !bankUpdateRequestDTO.getAcronym().equals(bankModel.getAcronym())) {
            Optional<BankModel> bankModelByAcronym = this.bankRepositoryAdapter.findByAcronymAndCompanyId(bankUpdateRequestDTO.getAcronym(), bankUpdateRequestDTO.getCompanyId());

            if (bankModelByAcronym.isPresent()) {
                throw new IllegalArgumentException("Bank with acronym " + bankUpdateRequestDTO.getAcronym() + " already exists");
            }

            bankModel.setAcronym(bankUpdateRequestDTO.getAcronym());
        }

        if (bankUpdateRequestDTO.getName() != null && !bankUpdateRequestDTO.getName().equals(bankModel.getName())) {
            Optional<BankModel> bankModelByName = this.bankRepositoryAdapter.findByNameAndCompanyId(bankUpdateRequestDTO.getName(), bankUpdateRequestDTO.getCompanyId());

            if (bankModelByName.isPresent()) {
                throw new IllegalArgumentException("Bank with name " + bankUpdateRequestDTO.getName() + " already exists");
            }

            bankModel.setName(bankUpdateRequestDTO.getName());
        }

        if (bankUpdateRequestDTO.getAccountHolder() != null && !bankUpdateRequestDTO.getAccountHolder().equals(bankModel.getAccountHolder())) {
            Optional<BankModel> bankModelByAccountHolder = this.bankRepositoryAdapter.findByAccountHolderAndCompanyId(bankUpdateRequestDTO.getAccountHolder(), bankUpdateRequestDTO.getCompanyId());

            if (bankModelByAccountHolder.isPresent()) {
                throw new IllegalArgumentException("Bank with account holder " + bankUpdateRequestDTO.getAccountHolder() + " already exists");
            }

            bankModel.setAccountHolder(bankUpdateRequestDTO.getAccountHolder());
        }

        if (bankUpdateRequestDTO.getAccountNumber() != null && !bankUpdateRequestDTO.getAccountNumber().equals(bankModel.getAccountNumber())) {
            Optional<BankModel> bankModelByAccountNumber = this.bankRepositoryAdapter.findByAccountNumberAndCompanyId(bankUpdateRequestDTO.getAccountNumber(), bankUpdateRequestDTO.getCompanyId());

            if (bankModelByAccountNumber.isPresent()) {
                throw new IllegalArgumentException("Bank with account number " + bankUpdateRequestDTO.getAccountNumber() + " already exists");
            }

            bankModel.setAccountNumber(bankUpdateRequestDTO.getAccountNumber());
        }

        if (bankUpdateRequestDTO.getIban() != null && !bankUpdateRequestDTO.getIban().equals(bankModel.getIban())) {
            Optional<BankModel> bankModelByIban = this.bankRepositoryAdapter.findByIbanAndCompanyId(bankUpdateRequestDTO.getIban(), bankUpdateRequestDTO.getCompanyId());

            if (bankModelByIban.isPresent()) {
                throw new IllegalArgumentException("Bank with iban " + bankUpdateRequestDTO.getIban() + " already exists");
            }

            bankModel.setIban(bankUpdateRequestDTO.getIban());
        }

        return bankMapper.toResponseDTO(bankRepositoryAdapter.save(bankModel));
    }

    @Override
    public void deleteBank(Long id) {
        this.bankRepositoryAdapter.findById(id);

        if (bankRepositoryAdapter.findById(id) == null) {
            throw new NoSuchElementException("Bank not found with id: " + id);
        }

        bankRepositoryAdapter.delete(id);
    }
}