package com.example.logistics.service;

// Client Request(JSON) -> Controller Layer ->
// Servic Layer(Business Rules) -> Repository Layer ->
// MongoDB Atlas

import com.example.logistics.exception.ResourceNotFoundException;
import com.example.logistics.exception.ShipmentAlreadyExistsException;
import com.example.logistics.model.Shipment;
import com.example.logistics.model.ShipmentStatus;
import com.example.logistics.model.dto.CreateShipmentRequest;
import com.example.logistics.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service // This tells Spring Boot to manage this class
         // as a background component ready to be injected elsewhere.
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    // Spring injects the repository into our service layer
    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    // View all
    public List<Shipment> getAllShipments(){
        return shipmentRepository.findAll();
    }

    // Insert
    public Shipment createShipment(CreateShipmentRequest request) {
        // Generate the unique ID using your millisecond logic
        String trackingId = "TRK-" + System.currentTimeMillis();

        // Safety check: Verify the Generated ID doesn't conflict
        boolean exists = shipmentRepository.existsByTrackingNumber(trackingId);
        if (exists) {
            throw new ShipmentAlreadyExistsException("Generated tracking number conflict occurred!");
        }



        Shipment newShipment = new Shipment();


        // Map the fields coming from our clean Minimalist Record
        newShipment.setOrigin(request.origin());
        newShipment.setDestination(request.destination());
        newShipment.setStatus(ShipmentStatus.PENDING);
        newShipment.setTrackingNumber(trackingId);
        newShipment.setTrackingNumber(trackingId);


        // Sends to mongoDB Atlas
        return shipmentRepository.save(newShipment);
    }

    // Update
    public Shipment updateShipmentStatus(String trackingNumber, ShipmentStatus newStatus){
        // Find the shipment first using our existing lookup method
        Shipment shipment = getShipmentByTracking(trackingNumber);

        // Change the status field to the new value
        shipment.setStatus(newStatus);

        // Save the updated document back to your local MongoDB
        return shipmentRepository.save(shipment);
    }

    // Search
    public Shipment getShipmentByTracking(String trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Shipment not found with tracking number: "
                        + trackingNumber));
    }
    public List<Shipment> getShipmentsByOrigin(String origin){
        return shipmentRepository.findByOrigin(origin);
    }
    public List<Shipment> getShipmentsByDestination(String destination){
        return  shipmentRepository.findByDestination(destination);
    }

    // Delete
    public void deleteShipmentByTracking(String trackingNumber){
        // Find it first so we can grab its internal MongoDB ID string
        Shipment shipment = getShipmentByTracking(trackingNumber);

        // Pass that ID to the built-in repository delete method
        shipmentRepository.deleteById(shipment.getId());
    }

    //Count
    public long countAllShipments() {
        return shipmentRepository.count();
    }

    public Shipment getShipmentByTrackingNumber(String trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Shipment with tracking number " + trackingNumber
                        + "not found."));
    }

    // Aggregation
    public Map<String, Object> getShipmentStats(){
        return shipmentRepository.getShipmentStatsAggregation();
    }
}
