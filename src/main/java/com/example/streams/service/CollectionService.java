package com.example.streams.service;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionService {
    public <T> Set<T>  getIntersection(List<T> s1, List<T> s2) {
        return s1.stream()
                .filter(s2::contains)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
//        HashSet<T> dd = new HashSet<>(s1);
//        dd.retainAll(s2);
//        return dd;
    }

    public List<String> getFirstTestArray() {
        return Arrays.asList("asd", "ddd", "asdasd", "bb");
    }

    public List<String> getSecondTestArray() {
        return Arrays.asList("asd", "d", "bb");
    }



    public List<Integer> getIntegerTestArray() {
        return Arrays.asList(1, 2, 3);
    }


}
