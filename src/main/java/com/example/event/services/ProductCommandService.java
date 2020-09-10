package com.example.event.services;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.example.event.commands.CreateProductCommand;
import com.example.event.commands.UpdateProductCommand;
import com.example.event.domain.entities.Product;
import com.example.event.domain.repository.ProductRepository;
import com.example.event.rest.dto.ProductCreateAndUpdateDTO;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductCommandService {
    
    private final CommandGateway commandGateway;

    private final ProductRepository repository;

    public CompletableFuture<Product> createProduct(ProductCreateAndUpdateDTO creationDTO) {
        long maxId = Optional.ofNullable(repository.maxProductId()).orElse(0L);
        long productId = maxId + 1;
        
        return this.commandGateway.send(new CreateProductCommand(
                String.valueOf(productId),
                creationDTO.getSalePrice(),
                creationDTO.getConsumerPrice(),
                creationDTO.getProductImages()
        ));
    }

    public CompletableFuture<Product> updateProduct(String productId, ProductCreateAndUpdateDTO dto) {
        return this.commandGateway.send(
            new UpdateProductCommand(
                productId,
                dto.getSalePrice(),
                dto.getConsumerPrice()
            )
        );
    }
}
