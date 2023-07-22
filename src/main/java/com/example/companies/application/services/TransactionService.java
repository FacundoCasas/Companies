package com.example.companies.application.services;

import com.example.companies.domain.models.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface TransactionService {
    List<Transaction> findByDateOfTransactionAfter(LocalDate date);
}
