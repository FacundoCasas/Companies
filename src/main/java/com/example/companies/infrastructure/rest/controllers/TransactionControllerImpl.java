package com.example.companies.infrastructure.rest.controllers;

import com.example.companies.application.dto.TransactionDTO;
import com.example.companies.application.services.TransactionService;
import com.example.companies.domain.models.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionControllerImpl implements TransactionController{

    private final TransactionService transactionService;

    public TransactionControllerImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @Override
    @PostMapping
    public ResponseEntity<Transaction> createCompany(@RequestBody TransactionDTO transaction) {
        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }
}
