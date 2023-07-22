package com.example.companies.application.services;

import com.example.companies.application.dto.CompanyDTO;
import com.example.companies.application.mapper.CompanyMapper;
import com.example.companies.domain.models.Transaction;
import com.example.companies.infrastructure.repositories.CompanyRepository;
import com.example.companies.domain.models.Company;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final TransactionServiceImpl transactionServiceImpl;

    public CompanyServiceImpl(CompanyRepository companyRepository,TransactionServiceImpl transactionServiceImpl) {
        this.companyRepository = companyRepository;
        this.transactionServiceImpl = transactionServiceImpl;
    }

    @Override
    public Company saveCompany(CompanyDTO companyDTO) {
        //TODO: logica de que no tenga repetido el CUIT, revisar si ponerlo en el Entity y atrapar el error que tira con un try catch
        return companyRepository.save(CompanyMapper.INSTANCE.companyDTOToCompany(companyDTO));
    }

    @Override
    public List<CompanyDTO> getCompaniesByLastAdhesion(LocalDate date) {
        return CompanyMapper.INSTANCE.companiesToCompanyDTOs(companyRepository.findByDateOfAccessionAfter(date));
    }

    /**
     * Retorna una lista de empresas que han realizado transacciones después de una fecha especifica.
     *
     * @param date La Fecha para Filtrar las transacciones.
     * @return Una lista de empresas que tienen transacciones posteriores a la fecha especifica.
     */
    @Override
    public List<CompanyDTO> getCompaniesByLastTransaction(LocalDate date) {
        List<Transaction> transactionsAfterDate = transactionServiceImpl.findByDateOfTransactionAfter(date);
        return CompanyMapper.INSTANCE.companiesToCompanyDTOs(extractCompaniesFromTransactions(transactionsAfterDate));
    }

    @Override
    public List<CompanyDTO> findAllCompanies() {
        return CompanyMapper.INSTANCE.companiesToCompanyDTOs(companyRepository.findAll());
    }

    /**
     * Extrae una lista sin duplicados de las empresas que contiene una lista de transacciones.
     *
     * @param transactions La lista de transacciones de las cuales extraeremos las empresas.
     * @return Una lista de empresas que estaban en las transaccciones sin duplicados.
     */

    private List<Company> extractCompaniesFromTransactions(List<Transaction> transactions){
        List<Company> companiesWithTransactionsLastMonth = null;

        if(!ObjectUtils.isEmpty(transactions)){
            companiesWithTransactionsLastMonth = transactions.stream()
                    .map(Transaction::getCompany)
                    .collect(Collectors.toList());

            companiesWithTransactionsLastMonth =  new ArrayList<>(new HashSet<>(companiesWithTransactionsLastMonth));
        }

        return companiesWithTransactionsLastMonth;
    }
}