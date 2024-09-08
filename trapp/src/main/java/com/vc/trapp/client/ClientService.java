package com.vc.trapp.client;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class ClientService {
    public static final String JPG = ".jpg";
    private final HttpClient httpClient;
    private String urlPizza = "https://status.pizza/";
    private String urlCat = "https://http.cat/";
    private String urlDog = "https://http.dog/";

    public ClientService(){
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }
    /**
     * Busca a imagem do status code como bytes.
     *
     * @param statusCode o código de status da imagem
     * @return um array de bytes representando a imagem
     * @throws Exception se ocorrer um erro ao buscar a imagem
     */
    private byte[] fetchImageUrlPizza(String url, String statusCode) throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url + statusCode))
                .GET()
                .build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());

        if(response.statusCode() != 200){
            throw new RuntimeException("Falha ao obter a imagem. Código de status: " + response.statusCode());
        }

        try (InputStream inputStream = response.body()) {
            return inputStream.readAllBytes();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler a imagem", e);
        }
    }

    private byte[] fetchImageUrl(String url, String statusCode) throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url + statusCode + JPG))
                .GET()
                .build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());

        if(response.statusCode() != 200){
            throw new RuntimeException("Falha ao obter a imagem. Código de status: " + response.statusCode());
        }

        try (InputStream inputStream = response.body()) {
            return inputStream.readAllBytes();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler a imagem", e);
        }
    }

    public byte[] fetchImagePizza(String statusCode) throws Exception {
        return fetchImageUrlPizza(urlPizza, statusCode);
    }

    public byte[] fetchImageCat(String statusCode) throws  Exception {
        return fetchImageUrl(urlCat, statusCode);
    }

    public byte[] fetchImageDog(String statusCode) throws Exception {
        return fetchImageUrl(urlDog, statusCode);
    }

}
