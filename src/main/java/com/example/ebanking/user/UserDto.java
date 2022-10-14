package com.example.ebanking.user;

import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private final long id;
    private final String accountNo;
    private final String username;
    private final String password;
    @Size(max = 10)
    private final String phoneNo;
    private final boolean loggedIn;
}