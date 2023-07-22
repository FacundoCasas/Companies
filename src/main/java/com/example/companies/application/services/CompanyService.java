package com.example.companies.application.services;

import com.example.companies.application.utils.DateUtils;
import com.example.companies.domain.models.Company;
import com.example.companies.domain.models.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface CompanyService {
    public Company saveCompany(Company company);
    public List<Company> getCompaniesByLastAdhesion(LocalDate date);
    public List<Company> getCompaniesByLastTransaction(LocalDate date);
    public List<Company> findAllCompanies();

}
