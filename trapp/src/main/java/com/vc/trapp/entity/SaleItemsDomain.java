package com.vc.trapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "saleItems")
public class SaleItemsDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saleItemsId")
    @Setter(AccessLevel.NONE)
    private Long saleItemsId;

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

