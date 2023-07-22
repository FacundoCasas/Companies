package com.example.companies.application.services;

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
    public Company saveCompany(Company company) {
        //TODO: logica de que no tenga repetido el CUIT, revisar si ponerlo en el Entity y atrapar el error que tira con un try catch
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getCompaniesByLastAdhesion(LocalDate date) {
        return companyRepository.findByDateOfAccessionAfter(date);
    }

    /**
     * Retorna una lista de empresas que han realizado transacciones después de una fecha especifica.
     *
     * @param date La Fecha para Filtrar las transacciones.
     * @return Una lista de empresas que tienen transacciones posteriores a la fecha especifica.
     */
    @Override
    public List<Company> getCompaniesByLastTransaction(LocalDate date) {
        List<Transaction> transactionsAfterDate = transactionServiceImpl.findByDateOfTransactionAfter(date);
        return extractCompaniesFromTransactions(transactionsAfterDate);
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
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