package com.example.companies.infrastructure.rest.controllers;

import com.example.companies.domain.models.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyController {
    ResponseEntity<Company> createCompany(Company company);
    ResponseEntity<List<Company>> getCompaniesByLastAdhesion(int months);
    ResponseEntity<List<Company>> getCompaniesByLastTransaction(int months);
    ResponseEntity<List<Company>> findAllCompanies();
}
