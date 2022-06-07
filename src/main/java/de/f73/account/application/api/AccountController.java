package de.f73.account.application.api;

import de.f73.account.domain.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

    AccountService accountService;

    @PostMapping("account")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        AccountDTO result = this.accountService.createAccount(accountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
