package com.example.streams.service;

import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorService {
    public static Collector<Object, StringBuilder, String> getSelfmadeCollector() {
        return Collector.of(
                StringBuilder::new,
                (sb, str) -> {
                    if (!sb.isEmpty()) {
                        sb.append(", ");
                    }
                    sb.append(str);
                },
                (sb1, sb2) -> {
                    if (!sb2.isEmpty()) {
                        if (!sb1.isEmpty()) {
                            sb1.append(", ");
                        }
                        sb1.append(sb2);
                    }
                    return sb1;
                },
                StringBuilder::toString
        );
    }
}
