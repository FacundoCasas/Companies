package com.example.companies.application.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDTO {
    private Long id;
    private String reason;
    private Double amount;
    private LocalDate transactionDate;
    private int debitAccount;
    private int creditAccount;

}