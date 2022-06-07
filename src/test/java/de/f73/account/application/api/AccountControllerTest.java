package de.f73.account.application.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.f73.account.domain.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class AccountControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    AccountService accountService;

    @Test
    void createAccount_AccountDTO_Returns_AccountDTO() throws Exception {
        // given
        ObjectMapper objectMapper = new ObjectMapper();
        AccountDTO accountDTO = new AccountDTO("Max", "Mustermann");

        AccountDTO resultAccountDTO = new AccountDTO(12345, "Max", "Mustermann");

        when(this.accountService.createAccount(any(AccountDTO.class))).thenReturn(resultAccountDTO);

        // when
        this.mvc.perform(post("/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accountDTO)))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(resultAccountDTO)));
    }
}
