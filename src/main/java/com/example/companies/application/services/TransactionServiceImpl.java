package com.example.companies.application.services;

import com.example.companies.application.dto.TransactionDTO;
import com.example.companies.application.exceptions.CompanyNotExistsException;
import com.example.companies.application.mapper.TransactionMapper;
import com.example.companies.domain.models.Transaction;
import com.example.companies.infrastructure.repositories.CompanyRepository;
import com.example.companies.infrastructure.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final CompanyRepository companyRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository,CompanyRepository companyRepository) {
        this.transactionRepository = transactionRepository;
        this.companyRepository = companyRepository;
    }
    @Override
    public List<Transaction> findByDateOfTransactionAfter(LocalDate date) {
        return transactionRepository.findByTransactionDateAfter(date);
    }

    @Override
    public Transaction saveTransaction(TransactionDTO transactionDTO) {
        if(!companyRepository.existsById(transactionDTO.getCompanyId())){
            throw new CompanyNotExistsException("La Empresa a la que se le quiere agregar una transaccion no existe");
        }
        return transactionRepository.save(TransactionMapper.INSTANCE.transactionDTOToTransaction(transactionDTO));
    }

}
