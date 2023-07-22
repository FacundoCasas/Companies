package com.example.companies.application.services;

import com.example.companies.infrastructure.repositories.CompanyRepository;
import com.example.companies.domain.models.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company saveCompany(Company company) {
        // Agregar lógica de validación y negocio si es necesario
        return companyRepository.save(company);
    }

}