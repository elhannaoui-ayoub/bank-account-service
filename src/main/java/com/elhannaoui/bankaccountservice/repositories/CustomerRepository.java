package com.elhannaoui.bankaccountservice.repositories;

import com.elhannaoui.bankaccountservice.entities.BankAccount;
import com.elhannaoui.bankaccountservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
