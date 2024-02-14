package com.vc.trapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDomain {

    @Id
    private Integer productId;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="price", nullable=false)
    private Double price;

    @Column(name="description")
    private String description;

    @Column(name="stock", nullable=false)
    private Integer stock;


}
