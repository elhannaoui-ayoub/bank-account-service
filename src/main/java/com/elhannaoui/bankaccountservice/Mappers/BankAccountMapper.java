package com.elhannaoui.bankaccountservice.Mappers;

import com.elhannaoui.bankaccountservice.dto.BankAccountRequestDTO;
import com.elhannaoui.bankaccountservice.dto.BankAccountResponseDTO;
import com.elhannaoui.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount1){
        /*BankAccountResponseDTO  bankAccount2 = BankAccountResponseDTO.builder()
                .id(bankAccount1.getId())
                .createdAt(bankAccount1.getCreatedAt())
                .balance(bankAccount1.getBalance())
                .type(bankAccount1.getType())
                .currency(bankAccount1.getCurrency())
                .build();

        return  bankAccount2;*/
        BankAccountResponseDTO  bankAccount2 = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount1,bankAccount2);
        return  bankAccount2;
    }
    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccount1){
        /*BankAccountResponseDTO  bankAccount2 = BankAccountResponseDTO.builder()
                .id(bankAccount1.getId())
                .createdAt(bankAccount1.getCreatedAt())
                .balance(bankAccount1.getBalance())
                .type(bankAccount1.getType())
                .currency(bankAccount1.getCurrency())
                .build();

        return  bankAccount2;*/
        BankAccount  bankAccount2 = new BankAccount();
        BeanUtils.copyProperties(bankAccount1,bankAccount2);
        return  bankAccount2;
    }
}
