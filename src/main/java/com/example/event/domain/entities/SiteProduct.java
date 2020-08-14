package com.example.event.domain.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SiteProduct {
    
    @Id
    private long siteProductId;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "consumer_price")
    private BigDecimal consumerPrice;
}
