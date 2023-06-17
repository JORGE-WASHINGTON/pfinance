package com.pfinance.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    private enum AccountType {
        CASH,
        BANK,
        CREDIT
    }

    @PostMapping("/accounts")
    public String createAccount() {
        return "This path creates an account";
    }


}
