package com.example.companies.application.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDTO {
    @Hidden
    private Long id;
    private String reason;
    private Double amount;
    private Long companyId;
    private LocalDate transactionDate;
    private int debitAccount;
    private int creditAccount;

}