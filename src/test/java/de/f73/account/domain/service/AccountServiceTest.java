package de.f73.account.domain.service;

import de.f73.account.application.api.AccountDTO;
import de.f73.account.infrastructure.AccountDAO;
import de.f73.account.infrastructure.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    AccountService accountService;

    @Mock
    AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        this.accountService = new AccountService(this.accountRepository);
    }

    @Test
    void createAccount_AccountDTO_returnsAccountDTOWithAccountNumber() {
        // given
        AccountDTO accountDTO = new AccountDTO("Max", "Mustermann");
        AccountDAO accountDAO = new AccountDAO(12345, "Max", "Mustermann");

        when(accountRepository.save(any(AccountDAO.class))).thenReturn(accountDAO);

        // when
        AccountDTO result = this.accountService.createAccount(accountDTO);

        // then
        assertNotNull(result);
        assertEquals(accountDTO.getFirstName(), result.getFirstName());
        assertEquals(accountDTO.getLastName(), result.getLastName());
        assertTrue(result.getAccountNumber() != 0);
    }

    @Test
    void getAllAccounts_noParams_returnsAccountDTOList() {
        // given
        List<AccountDAO> accountDAOList = Arrays.asList(
                new AccountDAO(11111, "A", "AA"),
                new AccountDAO(22222, "B", "BB"),
                new AccountDAO(33333, "C", "CC"),
                new AccountDAO(44444, "D", "DD"),
                new AccountDAO(55555, "E", "EE")
        );

        when(this.accountRepository.findAll()).thenReturn(accountDAOList);

        // when
        List<AccountDTO> results = this.accountService.getAllAccounts();

        // then
        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertEquals(accountDAOList.size(), results.size());
    }

    @Test
    void getAccount_accountNumber_returnsAccountDTO() {
        // given
        long accountNumber = 12345;
        AccountDTO accountDTO = new AccountDTO(12345, "Max", "Mustermann");
        AccountDAO accountDAO = new AccountDAO(12345, "Max", "Mustermann");

        when(this.accountRepository.findByAccountNumber(anyLong())).thenReturn(accountDAO);

        // when
        AccountDTO result = this.accountService.getAccount(accountNumber);

        // then
        assertNotNull(result);
        assertEquals(accountDTO.getAccountNumber(), result.getAccountNumber());
        assertEquals(accountDTO.getFirstName(), result.getFirstName());
        assertEquals(accountDTO.getLastName(), result.getLastName());
    }

}