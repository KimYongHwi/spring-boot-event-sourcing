package com.example.event.rest;

import java.util.concurrent.CompletableFuture;

import com.example.event.domain.entities.Product;
import com.example.event.services.ProductQueryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value ="/products")
@AllArgsConstructor
@Api(value = "Product Queries", description = "Product Query Events API")
public class ProductQueryController {

    private ProductQueryService service;

    @GetMapping("/{productId}")
    public CompletableFuture<Product> findById(@PathVariable("productId") String productId) {
        return service.findById(productId);
    }
}
