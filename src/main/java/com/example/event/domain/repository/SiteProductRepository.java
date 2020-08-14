package com.example.event.domain.repository;

import com.example.event.domain.entities.SiteProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteProductRepository extends JpaRepository<SiteProduct, Long> {

    @Query(value = "SELECT max(siteProductId) FROM SiteProduct")
	public Long maxSiteProductId();
}
