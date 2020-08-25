package com.example.event.domain.repository;

import com.example.event.domain.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT max(productId) FROM Product")
	public Long maxProductId();
}
