package de.f73.account.application.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class AccountControllerTest {

    @Autowired
    MockMvc mvc;

    ObjectMapper objectMapper = new ObjectMapper();

    AccountDTO validAccountDTO;
    String validAccountDTOJson;

    @BeforeEach
    void setUp() throws Exception {
        this.validAccountDTO = new AccountDTO("Alex", "Mustermann");
        this.validAccountDTOJson = this.objectMapper.writeValueAsString(this.validAccountDTO);
    }

    @Test
    void createAccount_AccountDTO_Returns_AccountDTO() throws Exception {
        //when
        this.mvc.perform(post("/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.validAccountDTOJson))
                // Then
                .andExpect(status().isCreated())
                .andExpect(content().json(this.validAccountDTOJson));
    }
}
