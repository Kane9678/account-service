package de.f73.account.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@RequiredArgsConstructor
@Getter
public class AccountDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final long accountNumber;
    private final String firstName;
    private final String lastName;

}
