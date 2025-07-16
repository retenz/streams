package com.example.streams;

import com.example.streams.entity.Order;
import com.example.streams.entity.Product;
import com.example.streams.entity.Transaction;
import com.example.streams.entity.User;
import com.example.streams.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamsApplication.class, args);

//		Тестирование задачи №1 (Группировка и агрегация)
        TransactionService transactionService = new TransactionService();
        List<Transaction> transactions = transactionService.getTestArray();

//		TODO: перенести в тесты
        Map<String, Double> result = transactionService.getSumOfTransactionsByCurrency(transactions);
        Map<String, Optional<LocalDate>> result1 = transactionService.getMaxDateOfTransactionsByCurrency(transactions);
        Map<String, String> result2 = transactionService.getMaxAmountOfTransactionsByCurrency(transactions);

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);

//		Тестирование задачи №2 (Партиционирование и фильтрация)
        UserService userService = new UserService();
        List<User> users = userService.getTestArray();

        List<User> adult = userService.getAdultUsers(users);
        List<User> notAdult = userService.getNotAdultUsers(users);

        System.out.println(adult);
        System.out.println(notAdult);

//		Тестирование задачи №3 (Цепочка операций с условиями)
        StringService stringService = new StringService();
        List<String> strings = stringService.getTestArray();
        Set<String> resultStrings = stringService.getSetStringStartWithALongerFive(strings);

        System.out.println(resultStrings);

//		Тестирование задачи №4 (Работа с вложенными структурами)
        OrderService orderService = new OrderService();
        List<Order> orders = orderService.getTestArray();
        Double ordersSum = orderService.getOrdersTotalSum(orders);
        Product maxPrice = orderService.getMostExpensiveProduct(orders);

        System.out.println(ordersSum);
        System.out.println(maxPrice);

//		Тестирование задачи №5 (Собственный коллектор)
        List<String> cars = Arrays.asList("Toyota", "Mazda", "Ferrari", "Nissan");
        System.out.println(cars.stream().collect(CollectorService.getSelfmadeCollector()));

//		Тестирование задачи №7 (Генерация статистики)
        StatisticService statisticService = new StatisticService();
        statisticService.getIntegerStatistic(statisticService.getTestArray());

//		Тестирование задачи №8 (Поиск пересечений в коллекции)
        CollectionService collectionService = new CollectionService();
        List<String> s1 = collectionService.getFirstTestArray();
        List<String> s2 = collectionService.getSecondTestArray();
        System.out.println(collectionService.getIntersection(s1, s2));

//      Тестирование задачи №9 (Сортировка с несколькими условиями)
        CombineSortService combineSortService = new CombineSortService();
        System.out.println(combineSortService.sortEmployee(combineSortService.getTestArray()));

//      Тестирование задачи №10 (Оптимизация стримов)
        LazyEvaluationService lazyEvaluationService = new LazyEvaluationService();
        System.out.println(lazyEvaluationService.getIntWithParameter(lazyEvaluationService.getTestArray()));
    }

}
