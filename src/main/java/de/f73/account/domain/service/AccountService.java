package de.f73.account.domain.service;

import de.f73.account.application.api.AccountDTO;
import de.f73.account.domain.model.Account;
import de.f73.account.infrastructure.AccountDAO;
import de.f73.account.infrastructure.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = mapAccountDtoToAccount(accountDTO);

        AccountDAO accountDAO = mapAccountToAccountDAO(account);

        AccountDAO resultAccountDAO = this.accountRepository.save(accountDAO);
        Account resultAccount = mapAccountDaoToAccount(resultAccountDAO);
        return mapAccountToAccountDto(resultAccount);
    }

    public List<AccountDTO> getAllAccounts() {
        return this.accountRepository.findAll().stream()
                .map(this::mapAccountDaoToAccount)
                .map(this::mapAccountToAccountDto)
                .collect(Collectors.toList());
    }

    public AccountDTO getAccount(long accountNumber) {
        AccountDAO resultDAO = this.accountRepository.findByAccountNumber(accountNumber);
        Account resultAccount = mapAccountDaoToAccount(resultDAO);
        return mapAccountToAccountDto(resultAccount);
    }

    private Account mapAccountDtoToAccount(AccountDTO dto) {
        return new Account(dto.getAccountNumber(), dto.getFirstName(), dto.getLastName());
    }

    private AccountDAO mapAccountToAccountDAO(Account account) {
        return new AccountDAO(account.getAccountNumber(), account.getFirstName(), account.getLastName());
    }

    private Account mapAccountDaoToAccount(AccountDAO dao) {
        return new Account(dao.getAccountNumber(), dao.getFirstName(), dao.getLastName());
    }

    private AccountDTO mapAccountToAccountDto(Account account) {
        return new AccountDTO(account.getAccountNumber(), account.getFirstName(), account.getLastName());
    }

}