package de.f73.account.application.api;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AccountDTO {

    private long accountNumber;
    private String firstName;
    private String lastName;

    public AccountDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


    }


}
