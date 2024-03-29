package com.vc.trapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sale")
public class SaleDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saleId")
    @Setter(AccessLevel.NONE)
    private Long saleId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerDomain customer;

    @Column(name = "saleDate")
    private Date saleDate;

    @Column(name = "totalAmount", nullable = false)
    private BigDecimal totalAmount;

}