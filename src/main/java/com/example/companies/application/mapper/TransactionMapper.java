package com.example.companies.application.mapper;

import com.example.companies.application.dto.TransactionDTO;
import com.example.companies.domain.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "company.id", target = "companyId")
    TransactionDTO transactionToTransactionDTO(Transaction transaction);

    @Mapping(source = "companyId", target = "company.id")
    Transaction transactionDTOToTransaction(TransactionDTO transactionDTO);
}