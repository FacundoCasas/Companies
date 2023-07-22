package com.example.companies.application.services;

import com.example.companies.application.dto.TransactionDTO;
import com.example.companies.application.mapper.TransactionMapper;
import com.example.companies.domain.models.Transaction;
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
        return transactionRepository.findByTransactionDateAfter(date);
    }

    @Override
    public Transaction saveTransaction(TransactionDTO transaction) {
        return transactionRepository.save(TransactionMapper.INSTANCE.transactionDTOToTransaction(transaction));
    }

}
