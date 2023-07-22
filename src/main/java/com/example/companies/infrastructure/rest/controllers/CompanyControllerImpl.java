package com.example.companies.infrastructure.rest.controllers;

import com.example.companies.application.dto.CompanyDTO;
import com.example.companies.application.utils.DateUtils;
import com.example.companies.domain.models.Company;
import com.example.companies.application.services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Company> createCompany(@RequestBody CompanyDTO company) {
        Company savedCompany = companyService.saveCompany(company);
        return ResponseEntity.ok(savedCompany);
    }

    @Override
    @GetMapping("/last-adhesion")
    public ResponseEntity<List<CompanyDTO>> getCompaniesByLastAdhesion(@RequestParam int months) {
        return ResponseEntity.ok(companyService.getCompaniesByLastAdhesion(DateUtils.subtractMonthsFromToday(months)));
    }
    @Override
    @GetMapping("/last-transaction")
    public ResponseEntity<List<CompanyDTO>> getCompaniesByLastTransaction(@RequestParam int months) {
        List<CompanyDTO> companies = companyService.getCompaniesByLastTransaction(DateUtils.subtractMonthsFromToday(months));
        return ResponseEntity.ok(companies);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> findAllCompanies() {
        List<CompanyDTO> companies = companyService.findAllCompanies();
        return ResponseEntity.ok(companies);
    }

}
