package com.example.logistics.model.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateShipmentRequest(
        @NotBlank(message = "Origin location is mandatory")
        String origin,

        @NotBlank(message = "Destination location is mandatory")
        String destination
) {
}
