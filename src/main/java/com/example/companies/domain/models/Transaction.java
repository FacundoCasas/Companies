package com.example.companies.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private Double amount;
    @ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;
    private LocalDate transactionDate;
    private int debitAccount;
    private int creditAccount;
}
