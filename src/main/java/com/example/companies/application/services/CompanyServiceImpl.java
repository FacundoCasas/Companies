package com.example.companies.application.services;

import com.example.companies.infrastructure.repositories.CompanyRepository;
import com.example.companies.domain.models.Company;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company saveCompany(Company company) {
        //TODO: logica de que no tenga repetido el CUIT, revisar si ponerlo en el Entity y atrapar el error que tira con un try catch
        return companyRepository.save(company);
    }

    @Override
    public List<Company> findByDateOfAccessionAfter(LocalDate date) {
        return companyRepository.findByDateOfAccessionAfter(date);
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

}