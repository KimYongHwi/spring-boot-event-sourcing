package com.example.event.rest;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.concurrent.CompletableFuture;

import com.example.event.domain.entities.SiteProduct;
import com.example.event.rest.dto.SiteProductCreationDTO;
import com.example.event.services.SiteProductCommandService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/site-products")
@Api(value = "SiteProduct Commands", description = "SiteProduct Commands API")
@AllArgsConstructor
public class SiteProductCommandController {
    
    private final SiteProductCommandService siteProductCommandService;

    @PostMapping
    @ResponseStatus(value = CREATED)
    public CompletableFuture<SiteProduct> createSiteProduct(@RequestBody SiteProductCreationDTO dto) {
        return this.siteProductCommandService.createSiteProduct(dto);
    }
}
