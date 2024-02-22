package com.vc.trapp.repository;

import com.vc.trapp.entity.ProductDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDomain, Long> {

    @Query(value = "SELECT * FROM product ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    ProductDomain findRandomProduct();
}
