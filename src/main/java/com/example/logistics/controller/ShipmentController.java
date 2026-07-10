package com.example.logistics.controller;

import com.example.logistics.model.Shipment;
import com.example.logistics.model.ShipmentStatus;
import com.example.logistics.model.dto.CreateShipmentRequest;
import com.example.logistics.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController     /*This tells Spring that this class is
                        responsible for handling web traffic
                         and returning data directly (like
                         text or JSON format) instead of
                         rendering an HTML page template.*/
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShipmentService shipmentService;

    // Controller now explicitly relies on the Service Layer
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    // Creates
    @PostMapping
    public ResponseEntity<Shipment> createShipment(@Valid @RequestBody CreateShipmentRequest request) {
        // Pass the validated DTO down to your service layer
        Shipment savedShipment = shipmentService.createShipment(request);
        return new ResponseEntity<>(savedShipment, HttpStatus.CREATED);
    }
    

    // Read
    // Fetches every single shipment directly from your MongoDb Atlas cluster
    @GetMapping
    public List<Shipment> getAllShipments(){
        return shipmentService.getAllShipments();
    }
    @GetMapping("/{trackingNumber}")
    public Shipment getShipmentByTracking(@PathVariable String trackingNumber) {
        return shipmentService.getShipmentByTracking(trackingNumber);
    }

    // Update
    @PatchMapping("/{trackingNumber}/status")
    public Shipment updateStatus(
            @PathVariable String trackingNumber,
            @RequestParam ShipmentStatus status) {
        return shipmentService.updateShipmentStatus(trackingNumber, status);
    }


    // Search
    @GetMapping("/search/origin")
    public List<Shipment> searchByOrigin(@RequestParam String origin) {
        return shipmentService.getShipmentsByOrigin(origin);
    }
    @GetMapping("/search/destination")
    public List<Shipment> searchByDestination(@RequestParam String
                                              destination) {
        return shipmentService.getShipmentsByDestination(destination);
    }
    // Count
    @GetMapping("/count")
    public String getDocumentCount() {
        long count = shipmentService.countAllShipments();
        return "Your local MongoDB currently holds exactly "
                + count +
                " shipment documents.";
    }

    // Delete
    @DeleteMapping("/{trackingNumber}")
    public String cancelAndDropShipment(@PathVariable String trackingNumber) {
        shipmentService.deleteShipmentByTracking(trackingNumber);
        return "Shipment " + trackingNumber + " has been successfully " +
                "deleted from the local database.";
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getShipmentStats() {
        return ResponseEntity.ok(shipmentService.getShipmentStats());
    }
}

// Client Request(JSON) -> Controller Layer ->
// Servic Layer(Business Rules) -> Repository Layer ->
// MongoDB Atlas
