package com.pfinance.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestDTO(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String password, @Email @NotBlank String email) {
}
