package com.bergaz.fundamentals.iteration_one.asynchronous.performant;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpBuildTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://github.com/"))
                .build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}