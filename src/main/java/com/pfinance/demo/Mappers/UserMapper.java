package com.pfinance.demo.Mappers;

import com.pfinance.demo.DTO.CreateUserRequestDTO;
import com.pfinance.demo.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;



@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User UserDtotoUser(CreateUserRequestDTO createUserRequestDTO);
}
