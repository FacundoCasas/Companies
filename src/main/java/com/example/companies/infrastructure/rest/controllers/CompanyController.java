package com.example.companies.infrastructure.rest.controllers;

import com.example.companies.domain.models.Company;
import org.springframework.http.ResponseEntity;

public interface CompanyController {
    ResponseEntity<Company> createCompany(Company company);
}
