package de.f73.account.application.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

@Getter
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@RequiredArgsConstructor
public class AccountDTO {

    private long accountNumber;
    private final String firstName;
    private final String lastName;

}
