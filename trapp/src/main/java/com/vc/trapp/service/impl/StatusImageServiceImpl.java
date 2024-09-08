package com.vc.trapp.service.impl;

import com.vc.trapp.client.ClientService;
import com.vc.trapp.service.StatusImageService;
import com.vc.trapp.service.ThrowingFunction;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class StatusImageServiceImpl implements StatusImageService {

    private final ClientService clientService;
    private final Map<String, ThrowingFunction<String, byte[]>> imageFetchers;

    public StatusImageServiceImpl(ClientService clientService, Map<String, Function<String, byte[]>> imageFetchers) {
        this.clientService = clientService;

        this.imageFetchers = new HashMap<>();
        this.imageFetchers.put("pizza", clientService::fetchImagePizza);
        this.imageFetchers.put("cat", clientService::fetchImageCat);
        this.imageFetchers.put("dog", clientService::fetchImageDog);
    }

    @Override
    public byte[] getImageStatusUrl(String statusCode, String type) throws Exception {
        //valida se o tipo existe
        //necessario criar uma interface funcional que aceite exceção
        ThrowingFunction<String, byte[]> imageFetcher = imageFetchers.get(type);
        if(imageFetcher == null){
            throw new IllegalArgumentException("Tipos suportados: dog, cat ou pizza");
        }

        byte[] imageBytes = imageFetcher.apply(statusCode);

        if(imageBytes == null || imageBytes.length == 0){
            throw  new RuntimeException("Imagem não encontrada");
        }

        return imageBytes;

    }
}
