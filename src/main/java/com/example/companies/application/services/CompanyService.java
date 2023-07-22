package com.example.companies.application.services;

import com.example.companies.application.dto.CompanyDTO;
import com.example.companies.domain.models.Company;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface CompanyService {
    public Company saveCompany(CompanyDTO company);
    public List<CompanyDTO> getCompaniesByLastAdhesion(LocalDate date);
    public List<CompanyDTO> getCompaniesByLastTransaction(LocalDate date);
    public List<CompanyDTO> findAllCompanies();

}
