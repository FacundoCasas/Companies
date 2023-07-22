package com.example.companies.infrastructure.repositories;

import com.example.companies.domain.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByDateOfTransactionAfter(LocalDate date);
}