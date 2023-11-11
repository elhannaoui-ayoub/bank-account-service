package com.elhannaoui.bankaccountservice.web;

import com.elhannaoui.bankaccountservice.dto.BankAccountRequestDTO;
import com.elhannaoui.bankaccountservice.dto.BankAccountResponseDTO;
import com.elhannaoui.bankaccountservice.entities.BankAccount;
import com.elhannaoui.bankaccountservice.repositories.BankAccountRepository;
import com.elhannaoui.bankaccountservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    public  AccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository=bankAccountRepository;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).
                orElseThrow(()->new RuntimeException(String.format("Account %s not found!",id)));
    }
    @PostMapping("/bankAccounts")
    /*@RequestMapping( value = "/bankAccounts",
            produces = "application/json",
            method = {RequestMethod.POST})*/
    /*public BankAccount save(@RequestBody BankAccount bankAccount){
        if(bankAccount.getId() ==null) bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }*/
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccount){

        return accountService.addAccount(bankAccount);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount bankAccount1 = bankAccountRepository.findById(id).orElseThrow();
        if(!Double.isNaN(bankAccount.getBalance())) bankAccount1.setBalance(bankAccount.getBalance());
        if(bankAccount.getType()!=null) bankAccount1.setType(bankAccount.getType());
        if(bankAccount.getCurrency() != null) bankAccount1.setCurrency(bankAccount.getCurrency());

        return bankAccountRepository.save(bankAccount1);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
