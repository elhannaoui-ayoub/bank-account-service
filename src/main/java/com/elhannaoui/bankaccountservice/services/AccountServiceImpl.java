package com.elhannaoui.bankaccountservice.services;

import com.elhannaoui.bankaccountservice.Mappers.BankAccountMapper;
import com.elhannaoui.bankaccountservice.dto.BankAccountRequestDTO;
import com.elhannaoui.bankaccountservice.dto.BankAccountResponseDTO;
import com.elhannaoui.bankaccountservice.entities.BankAccount;
import com.elhannaoui.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankAccountMapper bankAccountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountMapper.fromBankAccountRequestDTO(bankAccountDTO);
        bankAccount.setId(UUID.randomUUID().toString());
        BankAccount bankAccount1 =bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccount2 = bankAccountMapper.fromBankAccount(bankAccount1);

        return  bankAccount2;


    }
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountMapper.fromBankAccountRequestDTO(bankAccountDTO);
        bankAccount.setId(id);
        BankAccount bankAccount1 =bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccount2 = bankAccountMapper.fromBankAccount(bankAccount1);

        return  bankAccount2;


    }

}
