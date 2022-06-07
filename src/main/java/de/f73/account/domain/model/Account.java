package de.f73.account.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {

    private final long accountNumber;
    private final String firstName;
    private final String lastName;

}
