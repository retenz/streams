package com.example.streams.entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    List<Product> products;
}
