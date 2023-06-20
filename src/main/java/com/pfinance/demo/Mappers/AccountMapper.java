package com.pfinance.demo.Mappers;

import com.pfinance.demo.DTO.CreateAccountRequestDTO;
import com.pfinance.demo.Entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account AccountDtotoAccount(CreateAccountRequestDTO createAccountRequestDTO);

}
