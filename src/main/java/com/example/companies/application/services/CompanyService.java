package com.example.companies.application.services;

import com.example.companies.domain.models.Company;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface CompanyService {
    public Company saveCompany(Company company);
    public List<Company> findByDateOfAccessionAfter(LocalDate date);
    public List<Company> findAllCompanies();

}
