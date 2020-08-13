package com.bergaz.fundamentals.asynchronous.performant;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://www.amazon.com")).build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String responseStr = response.body().toString();

    }
}
