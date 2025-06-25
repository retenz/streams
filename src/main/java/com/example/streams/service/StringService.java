package com.example.streams.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringService {
    public Set<String> getSetStringStartWithALongerFive(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("A") && s.length() >= 5)
                .collect(Collectors.toSet());
    }


    public List<String> getTestArray() {
        return Arrays.asList("asd", "asddds", "AsddDs", "aaaaaaaa", "vasfsdsfg", "asddds", "aaaaB", "aaСa");
    }
}
