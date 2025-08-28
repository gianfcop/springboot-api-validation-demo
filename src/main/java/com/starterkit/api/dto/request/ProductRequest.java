/*
 * Spring Boot API Starter Kit
 * Copyright (c) 2025 Gianfranco Coppola. All rights reserved.
 * Commercial use permitted. Redistribution prohibited.
 */
package com.starterkit.api.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.starterkit.api.validation.custom.Sku;
import com.starterkit.api.validation.groups.OnCreate;
import com.starterkit.api.validation.groups.OnUpdate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    @Schema(description = "Product name", example = "iPhone 15 Pro")
    @NotBlank(message = "Product name cannot be blank", groups = {OnCreate.class, OnUpdate.class})
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters", groups = {OnCreate.class, OnUpdate.class})
    String name;

    @Schema(description = "Price of the product", example = "999.99")
    @NotNull(message = "Price cannot be null", groups = OnCreate.class)
    @Positive(message = "Price must be positive", groups = {OnCreate.class, OnUpdate.class})
    @Min(value = 1, message = "Price must be at least 1", groups = {OnCreate.class, OnUpdate.class})
    @Max(value = 10000, message = "Price must not exceed 10000", groups = {OnCreate.class, OnUpdate.class})
    Double price;

    @Schema(description = "ID of the category to which the product belongs", example = "1")
    @NotNull(message = "Category ID is required", groups = OnCreate.class)
    Long categoryId;

    @Schema(description = "List of product tags", example = "[\"smartphone\", \"apple\", \"mobile\"]")
    @Valid
    @Size(max = 5, message = "You can add up to 5 tags", groups = {OnCreate.class, OnUpdate.class})
    List<@NotBlank(message = "Tag cannot be blank") String> tags;

    @Schema(description = "Email for warranty support", example = "support@example.com")
    @Email(message = "Invalid email format for warranty", groups = {OnCreate.class, OnUpdate.class})
    String emailForWarranty;

    @Schema(description = "Discount percentage (0 to 80)", example = "15")
    @Min(value = 0, message = "Discount cannot be negative", groups = {OnCreate.class, OnUpdate.class})
    @Max(value = 80, message = "Discount cannot exceed 80%", groups = {OnCreate.class, OnUpdate.class})
    Integer discountPercentage;

    @Schema(description = "Date when the product will be available", example = "2025-01-15")
    @Future(message = "Availability date must be in the future", groups = {OnCreate.class, OnUpdate.class})
    LocalDate availabilityDate;

    @Schema(description = "Date when the product was created", example = "2025-05-10")
    @Past(message = "Created date must be in the past", groups = OnCreate.class)
    LocalDate createdAt;

    @Schema(description = "Stock Keeping Unit (8 uppercase letters or digits)", example = "AB12CD34")
    @Sku(message = "SKU must be 8 uppercase letters or digits", groups = {OnCreate.class, OnUpdate.class})
    String sku;
}
