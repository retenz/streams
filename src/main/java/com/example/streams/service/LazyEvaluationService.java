package com.example.streams.service;

import java.util.Arrays;
import java.util.List;

public class LazyEvaluationService {
    public Integer getIntWithParameter(List<Integer> integers) {
        return integers.stream()
                .filter(i -> i % 2 == 0 && i > 100)
                .filter(i -> Math.sqrt(i) % 1 == 0)
                .findAny().orElse(null);
    }

    public List<Integer> getTestArray() {
        return Arrays.asList(81, 101, 121, 144, 525);
    }
}
