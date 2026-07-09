package com.example.logistics.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shipment")

public class Shipment {

    @Id
    private String id;

    @NotBlank(message = "Tracking number is mandatory")
    @Size(min = 5, max = 20, message = "Tracking number must be between 5 and 20 characters")
    @Indexed(unique = true)// This tells MongoDB to enforce absolute uniqueness
    private  String trackingNumber;

    @NotBlank(message = "Origin name cannot be blank")
    private String origin;

    @NotBlank(message = "Destination name cannot be blank")
    private String destination;

    @NotBlank(message = "Status name cannot be blank")
    private ShipmentStatus status; // e.g., PENDING, IN_TRANSIT, DELIVERED

    @CreatedDate
    @Field("created_at") // changing the java camelCase into snake_case in mongodb
    private java.time.Instant createdAt;

    @LastModifiedDate
    @Field("updated_at")
    private java.time.Instant updateAt;

    public Instant getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ShipmentStatus getStatus() {
        return status;
    }
    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
