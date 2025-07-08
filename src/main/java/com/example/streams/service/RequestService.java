package com.example.streams.service;

import lombok.Data;
import org.springframework.core.task.VirtualThreadTaskExecutor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Data
public class RequestService {
    public void parallelGetRequest(List<String> urls) {
        HttpClient client = HttpClient.newHttpClient();
        List<String> resp = urls.parallelStream()
                .map(url -> {
                    try {
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .GET()
                                .build();
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        return response.body();
                    } catch (IOException | InterruptedException e) {
                        System.out.println(e);;
                        return null;
                    }
                }).toList();

        resp.forEach(System.out::println);
    }

    public List<String> parallelGetRequestWithCompletableFuture(List<String> urls) {
        try (HttpClient client = HttpClient.newBuilder()
                .executor(Executors.newVirtualThreadPerTaskExecutor())
                .build()
        ) {
            return urls.parallelStream()
                    .map(URI::create)
                    .map(uri -> client.sendAsync(
                                    HttpRequest.newBuilder(uri).GET().build(), HttpResponse.BodyHandlers.ofString())
                            .thenApply(HttpResponse::body)
                            .exceptionally(e -> {
                                System.out.println(e);
                                return null;
                            }))
                    .map(CompletableFuture::join)
                    .filter(Objects::nonNull)
                    .toList();
        }
    }
}
