package org.alura.literalura.Api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.alura.literalura.Model.Response.GutendexResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiGutendex {
    public static final String API_URL = "https://gutendex.com/books?search=";

    public GutendexResponse convert(String search) {
        var client = HttpClient.newHttpClient();
        var httpRequest = HttpRequest.newBuilder().uri(URI.create(API_URL.concat(search.replace(" ", "%20")))).build();
        try {
            var httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            var json = httpResponse.body();
            var mapper = new ObjectMapper();
            return mapper.readValue(json, GutendexResponse.class);
        } catch (Exception e) {
            return new GutendexResponse();
        }

    }
}
