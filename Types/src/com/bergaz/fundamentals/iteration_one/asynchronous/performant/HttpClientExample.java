package com.bergaz.fundamentals.iteration_one.asynchronous.performant;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {

        Executor executor = Executors.newSingleThreadExecutor();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://www.amazon.com")).build();

        //HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //String responseStr = response.body().toString();

        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        future.thenAcceptAsync(
                response -> {
                    System.out.println("Response length: " + response.body().toString().length() +
                            " thread: " + Thread.currentThread().getName());
                }, executor)
                .thenRun(() -> System.out.println("DONE!!!"))
                .join();

        //int length = future.join().body().toString().length();
        //System.out.println("Response length: " + length);

    }
}
