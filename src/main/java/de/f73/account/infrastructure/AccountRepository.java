package de.f73.account.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountDAO, Long> {

    AccountDAO findByAccountNumber(long accountNumber);

}
