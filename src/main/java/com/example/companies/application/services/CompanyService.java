package com.example.companies.application.services;

import com.example.companies.domain.models.Company;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
    public Company saveCompany(Company company);
}
