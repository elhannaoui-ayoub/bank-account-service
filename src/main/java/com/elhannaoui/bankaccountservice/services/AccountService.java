package com.elhannaoui.bankaccountservice.services;

import com.elhannaoui.bankaccountservice.dto.BankAccountRequestDTO;
import com.elhannaoui.bankaccountservice.dto.BankAccountResponseDTO;
import com.elhannaoui.bankaccountservice.entities.BankAccount;

public interface AccountService {

    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO);
}
