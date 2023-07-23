package com.example.companies.infrastructure.rest.controllers;

import com.example.companies.application.dto.TransactionDTO;
import com.example.companies.domain.models.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

public interface TransactionController {
    @Operation(summary = "Crea una nueva Transacción",description = "Crea una nueva Transacción y verifica que exista la Empresa en la base de datos")
    ResponseEntity<Transaction> createCompany(TransactionDTO transaction);
}
