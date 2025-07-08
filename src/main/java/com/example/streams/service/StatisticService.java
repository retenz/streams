package com.example.streams.service;

import lombok.Data;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StatisticService {
    public void getIntegerStatistic(List<Integer> integers) {
        IntSummaryStatistics statistics = integers.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Сумма:" + statistics.getSum() +
                            "\nСреднее значение: " + statistics.getAverage()+
                            "\nМинимальное значение: " + statistics.getMin()+
                            "\nКоличество элементов: " + statistics.getCount()
        );
    }

    public List<Integer> getTestArray() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    }
}
