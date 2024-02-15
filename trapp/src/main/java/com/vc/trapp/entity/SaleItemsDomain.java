package com.vc.trapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "saleItems")
public class SaleItemsDomain {

    @ManyToOne
    @JoinColumn(name = "saleId")
    private SaleDomain sale;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductDomain product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unitPrice", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "totalPrice", nullable = false)
    private BigDecimal totalPrice;

}

