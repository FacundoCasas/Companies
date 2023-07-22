package com.example.companies.infrastructure.rest.controllers;

import com.example.companies.domain.models.Company;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyController {
    @Operation(summary = "Crea una nueva Empresa")
    ResponseEntity<Company> createCompany(Company company);
    @Operation(summary = "Busca las Empresas que han adherido los ultimos meses")
    ResponseEntity<List<Company>> getCompaniesByLastAdhesion(@Parameter(description = "Cantidad de meses para la busqueda") int months);
    @Operation(summary = "Busca las Empresas que han realizado transacciones los ultimos meses")
    ResponseEntity<List<Company>> getCompaniesByLastTransaction(@Parameter(description = "Cantidad de meses para la busqueda") int months);
    @Operation(summary = "Busca todas las Empresas")
    ResponseEntity<List<Company>> findAllCompanies();
}
