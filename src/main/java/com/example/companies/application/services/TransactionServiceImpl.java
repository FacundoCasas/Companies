package com.example.companies.application.services;

import com.example.companies.domain.models.Transaction;
import com.example.companies.infrastructure.repositories.CompanyRepository;
import com.example.companies.infrastructure.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public List<Transaction> findByDateOfTransactionAfter(LocalDate date) {
        return transactionRepository.findByDateOfTransactionAfter(date);
    }

}
