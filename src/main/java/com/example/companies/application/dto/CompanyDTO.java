package com.example.companies.application.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CompanyDTO {
    private Long id;
    private String cuit;
    private String businessName;
    private LocalDate dateOfAccession;
    private List<TransactionDTO> transactions;
}
