/*
 * Spring Boot API Starter Kit
 * Copyright (c) 2025 Gianfranco Coppola. All rights reserved.
 * Commercial use permitted. Redistribution prohibited.
 */
package com.starterkit.api.controller;

import com.starterkit.api.dto.request.ProductRequest;
import com.starterkit.api.dto.response.ProductResponse;
import com.starterkit.api.service.ProductService;
import com.starterkit.api.validation.groups.OnCreate;
import com.starterkit.api.validation.groups.OnUpdate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Validated
@Tag(name = "Products", description = "CRUD operations for products")
public class ProductController {

    private final ProductService productService;

    @Operation(
        summary = "Create a new product",
        description = "Creates a product using a ProductRequest DTO",
        responses = {
            @ApiResponse(responseCode = "201", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content(schema = @Schema(hidden = true)))
        }
    )
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> createProduct(
            @Validated(OnCreate.class) @RequestBody ProductRequest request) {

        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
        summary = "Get all products",
        description = "Retrieves a list of all products"
    )
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(
        summary = "Update an existing product",
        description = "Updates the details of an existing product by ID",
        parameters = {
          @Parameter(description = "ID of the product to update", in = ParameterIn.PATH, example = "101")  
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Product or Category not found", content = @Content(schema = @Schema(hidden = true)))
        }
    )
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable @Positive(message = "ID must be positive") Long id,
            @Validated(OnUpdate.class) @RequestBody ProductRequest request) {

        ProductResponse response = productService.updateProduct(id, request);
        return ResponseEntity.ok(response);
    }

    @Operation(
        summary = "Delete a product",
        description = "Deletes a product by ID",
        parameters = {
            @Parameter(description = "ID of the product to delete", in = ParameterIn.PATH, example = "101")
        },
        responses = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable @Positive(message = "ID must be positive") Long id) {

        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
