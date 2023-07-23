package com.example.companies.application.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CompanyDTO {
    @Hidden
    private Long id;
    private String cuit;
    private String businessName;
    private LocalDate dateOfAccession;
    @Hidden
    private List<TransactionDTO> transactions;
}
