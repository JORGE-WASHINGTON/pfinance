package com.pfinance.demo.DTO;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateAccountRequestDTO(@NotBlank BigDecimal balance, @NotBlank String title) {

}
