package com.pfinance.demo.Repositories;

import com.pfinance.demo.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}