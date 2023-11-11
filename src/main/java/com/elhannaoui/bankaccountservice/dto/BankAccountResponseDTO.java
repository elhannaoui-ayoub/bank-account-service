package com.elhannaoui.bankaccountservice.dto;

import com.elhannaoui.bankaccountservice.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {

    private String id;
    private Date createdAt;
    private double balance;
    private String currency;

    private AccountType type;
}
