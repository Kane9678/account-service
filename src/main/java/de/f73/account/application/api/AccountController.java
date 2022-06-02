package de.f73.account.application.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @PostMapping("account")
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) {
        return new AccountDTO("Alex", "Mustermann");
    }

}
