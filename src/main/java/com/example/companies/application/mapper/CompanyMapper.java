package com.example.companies.application.mapper;

import com.example.companies.application.dto.CompanyDTO;
import com.example.companies.domain.models.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDTO companyToCompanyDTO(Company company);

    Company companyDTOToCompany(CompanyDTO companyDTO);

    List<CompanyDTO> companiesToCompanyDTOs(List<Company> companies);

    List<Company> companyDTOsToCompanies(List<CompanyDTO> companyDTOs);
}