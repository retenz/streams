package com.example.streams.service;

import com.example.streams.entity.Transaction;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionService {
    public Map<String, Double> getSumOfTransactionsByCurrency(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency, Collectors.summingDouble(Transaction::getAmount)));
    }

    public Map<String, Optional<LocalDate>> getMaxDateOfTransactionsByCurrency(List<Transaction> transactions) {
        return transactions.stream()
                .collect(
                        Collectors.groupingBy(
                                Transaction::getCurrency,
                                Collectors.mapping(Transaction::getDate, Collectors.maxBy(LocalDate::compareTo))
                        )
                );
    }

    public Map<String, Transaction> getMaxAmountOfTransactionsByCurrency(List<Transaction> transactions) {
        return transactions.stream()
                .collect(
                        Collectors.groupingBy(
                                Transaction::getCurrency,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Transaction::getAmount)),
                                        Optional::get
                                ))
                        );
    }

    public List<Transaction> getTestArray() {
        Transaction t1 = new Transaction();
        t1.setId(1);
        t1.setAmount(7.4);
        t1.setCurrency("Rubble");
        t1.setDate(LocalDate.of(2024,12,12));
        Transaction t2 = new Transaction();
        t2.setId(2);
        t2.setAmount(42.0);
        t2.setCurrency("Dollar");
        t2.setDate(LocalDate.of(2025,12,12));
        Transaction t3 = new Transaction();
        t3.setId(3);
        t3.setAmount(31.2);
        t3.setCurrency("Euro");
        t3.setDate(LocalDate.of(2026,12,12));

        Transaction t4 = new Transaction();
        t4.setId(4);
        t4.setAmount(4.1);
        t4.setCurrency("Rubble");
        t4.setDate(LocalDate.of(2027,12,12));
        Transaction t5 = new Transaction();
        t5.setId(5);
        t5.setAmount(66.6);
        t5.setCurrency("Euro");
        t5.setDate(LocalDate.of(2028,12,12));

        return Arrays.asList(t1, t2, t3, t4, t5);
    }
}
