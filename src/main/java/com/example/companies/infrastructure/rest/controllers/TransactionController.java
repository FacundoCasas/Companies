package com.example.companies.infrastructure.rest.controllers;

import com.example.companies.application.dto.TransactionDTO;
import com.example.companies.domain.models.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

public interface TransactionController {
    @Operation(summary = "Crea una nueva Transacción")
    ResponseEntity<Transaction> createCompany(TransactionDTO transaction);
}
