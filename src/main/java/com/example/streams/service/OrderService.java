package com.example.streams.service;

import com.example.streams.entity.Order;
import com.example.streams.entity.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    public Double getOrdersTotalSum(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Product getMostExpensiveProduct(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .max(Comparator.comparing(Product::getPrice))
                .orElseGet(null);
    }

    public List<Order> getTestArray() {
        Product product1 = new Product();
        product1.setPrice(100.0);
        Product product2 = new Product();
        product2.setPrice(1000.0);

        Order order1 = new Order();
        order1.setProducts(Arrays.asList(product1, product1, product1, product1));
        Order order2 = new Order();
        order2.setProducts(Arrays.asList(product2, product1));

        return Arrays.asList(order1, order2);
    }
}
