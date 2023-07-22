package com.example.companies.infrastructure.rest.controllers;

import com.example.companies.domain.models.Company;
import com.example.companies.application.services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyControllerImpl implements CompanyController {
    private final CompanyService companyService;

    public CompanyControllerImpl(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company savedCompany = companyService.saveCompany(company);
        return ResponseEntity.ok(savedCompany);
    }

    // Implementar otros métodos del controlador para leer, actualizar y eliminar compañías según sea necesario
}
