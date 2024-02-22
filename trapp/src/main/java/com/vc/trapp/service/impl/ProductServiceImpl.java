package com.vc.trapp.service.impl;

import com.vc.trapp.entity.ProductDomain;
import com.vc.trapp.record.Product;
import com.vc.trapp.repository.ProductRepository;
import com.vc.trapp.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl  implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        ProductDomain productDomain = ProductDomain.builder()
                .productId(product.productId()) //TODO VERIFICAR
                .price(product.price())
                .description(product.description())
                .name(product.name())
                .stock(product.stock())
                .build();

        ProductDomain productCreated = productRepository.save(productDomain);
        return mapProductDomainToProduct(productCreated);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<ProductDomain> productDomainOptional = productRepository.findById(id);
        return productDomainOptional.map(productDomain ->
                new Product(productDomain.getProductId(), productDomain.getName(), productDomain.getPrice(), productDomain.getDescription(), productDomain.getStock()));

    }

    public Product getRandomProduct() {
        ProductDomain randomProduct = productRepository.findRandomProduct();
        return mapProductDomainToProduct(randomProduct);
    }

    private Product mapProductDomainToProduct(ProductDomain product) {
        return new Product(
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getStock()
        );
    }

}