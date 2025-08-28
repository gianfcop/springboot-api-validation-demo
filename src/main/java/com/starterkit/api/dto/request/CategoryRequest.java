/*
 * Spring Boot API Starter Kit
 * Copyright (c) 2025 Gianfranco Coppola. All rights reserved.
 * Commercial use permitted. Redistribution prohibited.
 */
package com.starterkit.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequest {

    @Schema(description = "Category name", example = "Electronics")
    @NotBlank(message = "Category name cannot be blank")
    @Size(min = 3, max = 50, message = "Category name must be between 3 and 50 characters")
    String name;

    @Schema(description = "Detailed description of the category", example = "All kinds of electronic devices and accessories")
    @Size(max = 200, message = "Description can be up to 200 characters")
    String description;

}
