package com.example.companies.infrastructure.repositories;

import com.example.companies.domain.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
