package de.f73.account.application.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class AccountControllerTest {
    @Autowired
    MockMvc mvc;
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void createAccount_AccountDTO_Returns_AccountDTO() throws Exception {
        //given
        AccountDTO accountDTO = new AccountDTO("Alex", "Schulz");
        //when
        this.mvc.perform(MockMvcRequestBuilders.post("/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(accountDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(accountDTO)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value(123));
    }
}
