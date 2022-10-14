package com.example.ebanking.account;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Account} entity
 */
@Data
public class AccountDto implements Serializable {
    private final String accountNo;
    private final String branchName;
    private final String NIC;
    private final String Name;
    private final String accountType;
    private final double accountBal;
}