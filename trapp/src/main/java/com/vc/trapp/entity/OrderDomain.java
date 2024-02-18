package com.vc.trapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class OrderDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    @Setter(AccessLevel.NONE)
    private Long orderId;

    @Column(name = "orderDate", nullable = false)
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductDomain product;

}