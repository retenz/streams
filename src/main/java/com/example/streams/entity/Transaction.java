package com.example.streams.entity;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class Transaction {
    private Integer id;
    private Double amount;
    private String currency;
    private LocalDate date;
}
