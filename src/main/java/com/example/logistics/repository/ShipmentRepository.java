package com.example.logistics.repository;

import com.example.logistics.model.Shipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository extends
        MongoRepository<Shipment, String>, CustomShipmentRepository {
    boolean existsByTrackingNumber(String trackingNumber);

    //  Spring will automatically generate the database query for this method!
    Optional<Shipment> findByTrackingNumber(String trackingNumber);

    // Find all shipments leaving from a specific city
    // The :0 means the first parameter, and options='i' ignores the case
    @Query(value = "{ 'origin': { $regex: ?0, $options: 'i' } }")
    List<Shipment> findByOrigin(String origin);

    // Find all shipments arriving at a specific city
    @Query(value = "{ 'destination': { $regex: ?0, $options: 'i' } }")
    List<Shipment> findByDestination(String destination);
}
