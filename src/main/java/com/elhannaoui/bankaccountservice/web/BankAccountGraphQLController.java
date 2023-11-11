package com.elhannaoui.bankaccountservice.web;

import com.elhannaoui.bankaccountservice.dto.BankAccountRequestDTO;
import com.elhannaoui.bankaccountservice.dto.BankAccountResponseDTO;
import com.elhannaoui.bankaccountservice.entities.BankAccount;
import com.elhannaoui.bankaccountservice.entities.Customer;
import com.elhannaoui.bankaccountservice.repositories.BankAccountRepository;
import com.elhannaoui.bankaccountservice.repositories.CustomerRepository;
import com.elhannaoui.bankaccountservice.services.AccountService;
import com.elhannaoui.bankaccountservice.services.AccountServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRepository customerRepository;
    private AccountService accountService;
    @QueryMapping
    public List<BankAccount> accountsList(){
    return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping // pour les opérations d'ajout ou modification
    public BankAccountResponseDTO addBankAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping // pour les opérations d'ajout ou modification
    public BankAccountResponseDTO updateBankAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping // pour les opérations d'ajout ou modification
    public Boolean deleteBankAccount(@Argument String id){
        try{
            bankAccountRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }


    }

    @QueryMapping
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
}

/*record BankAccountDTO(Double balance,String type,String currency){

}*/