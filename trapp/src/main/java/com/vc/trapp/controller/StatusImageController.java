package com.vc.trapp.controller;

import com.vc.trapp.service.StatusImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusImageController {

    private final StatusImageService statusImageService;

    public StatusImageController(StatusImageService statusImageService) {
        this.statusImageService = statusImageService;
    }

    @GetMapping("/image")
    public ResponseEntity<byte[]> getImage(@RequestParam String statusCode, @RequestParam String type) {

        try {
            // Obtém os bytes da imagem do serviço
            byte[] imageBytes = statusImageService.getImageStatusUrl(statusCode, type);

            // Configura os cabeçalhos da resposta
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(imageBytes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage().getBytes());
        }
    }
}