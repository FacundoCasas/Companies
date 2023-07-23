package com.example.companies.infrastructure.repositories;

import com.example.companies.domain.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByDateOfAccessionAfter(LocalDate date);

    boolean existsByCuit(String cuit);
    boolean existsById(Long id);
}
