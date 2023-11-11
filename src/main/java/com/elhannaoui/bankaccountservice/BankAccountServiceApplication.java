package com.elhannaoui.bankaccountservice;

import com.elhannaoui.bankaccountservice.entities.BankAccount;
import com.elhannaoui.bankaccountservice.entities.Customer;
import com.elhannaoui.bankaccountservice.enums.AccountType;
import com.elhannaoui.bankaccountservice.repositories.BankAccountRepository;
import com.elhannaoui.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {
    private final CustomerRepository customerRepository;

    public BankAccountServiceApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(BankAccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){

        return args ->{
            Stream.of("Mohamed","Yassine","Hanae").forEach(
                    c->{
                        Customer customer =Customer.builder()
                                .name(c)
                        .build();

                        customerRepository.save(customer);
                    }
            );

            customerRepository.findAll().forEach(customer -> {
                for(int i=1;i<2;i++){
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                            .balance(Math.random()*90000)
                            .createdAt(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });


        };
    }
}
