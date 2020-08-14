package com.example.event.services;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.example.event.commands.CreateSiteProductCommand;
import com.example.event.domain.entities.SiteProduct;
import com.example.event.domain.repository.SiteProductRepository;
import com.example.event.rest.dto.SiteProductCreationDTO;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SiteProductCommandService {
    
    private final CommandGateway commandGateway;

    private final SiteProductRepository repository;

    public CompletableFuture<SiteProduct> createSiteProduct(SiteProductCreationDTO creationDTO) {
        long maxId = Optional.ofNullable(repository.maxSiteProductId()).orElse(0L);
        long siteProductId = maxId + 1;
        
        return this.commandGateway.send(new CreateSiteProductCommand(
                siteProductId,
                creationDTO.getSalePrice(),
                creationDTO.getConsumerPrice()
        ));
    }
}
