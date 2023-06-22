package com.pfinance.demo.Services;

import com.pfinance.demo.DTO.CreateAccountRequestDTO;
import com.pfinance.demo.Entities.Account;
import com.pfinance.demo.Entities.User;
import com.pfinance.demo.Mappers.AccountMapper;
import com.pfinance.demo.Repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserService userService;
    private final AccountMapper accountMapper;

    protected AccountService(AccountRepository accountRepository, UserService userService, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.userService = userService;
        this.accountMapper = accountMapper;
    }

        public Account createAccount(Long userId, CreateAccountRequestDTO createAccountRequestDTO) {
            User user = userService.getUserById(userId);
            Account newAccount = accountMapper.AccountDtotoAccount(createAccountRequestDTO);
            newAccount.setUser(user);
            try {
                return accountRepository.save(newAccount);
            } catch (Exception ex){
                System.out.println("An error occurred while creating the account: " + ex.getMessage());
                throw ex;
            }
        }

}
