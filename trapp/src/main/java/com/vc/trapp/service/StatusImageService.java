package com.vc.trapp.service;

public interface StatusImageService {
    /**
     * Obtém a imagem correspondente ao status e tipo fornecidos.
     *
     * @param statusCode o código de status da imagem
     * @param type o tipo de imagem
     * @return um array de bytes representando a imagem
     * @throws Exception se ocorrer um erro ao obter a imagem
     */
    byte[] getImageStatusUrl(String statusCode, String type) throws Exception;
}

