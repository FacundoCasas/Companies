package com.example.companies.infrastructure.rest.controllers;

import com.example.companies.application.utils.DateUtils;
import com.example.companies.domain.models.Company;
import com.example.companies.application.services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/last-adhesion")
    public ResponseEntity<List<Company>> getCompaniesByLastAdhesion(@RequestParam int months) {
        return ResponseEntity.ok(companyService.getCompaniesByLastAdhesion(DateUtils.subtractMonthsFromToday(months)));
    }

    @GetMapping("/last-transaction")
    public ResponseEntity<List<Company>> getCompaniesByLastTransaction(@RequestParam int months) {
        return ResponseEntity.ok(companyService.getCompaniesByLastTransaction(DateUtils.subtractMonthsFromToday(months)));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Company>> findAllCompanies() {
        List<Company> companies = companyService.findAllCompanies();
        return ResponseEntity.ok(companies);
    }

}
