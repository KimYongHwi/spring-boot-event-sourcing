package com.example.event.services;

import java.util.concurrent.CompletableFuture;

import com.example.event.domain.entities.Product;
import com.example.event.queries.FindProductByIdQuery;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductQueryService {

    private QueryGateway queryGateway;

    public CompletableFuture<Product> findById(String productId) {
        return this.queryGateway.query(new FindProductByIdQuery(Long.parseLong(productId)), ResponseTypes.instanceOf(Product.class));
    }
}
