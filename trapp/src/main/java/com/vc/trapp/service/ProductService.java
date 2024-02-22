package com.vc.trapp.service;

import com.vc.trapp.record.Product;

import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    Optional<Product> getProductById(Long id);
    Product getRandomProduct();

}
