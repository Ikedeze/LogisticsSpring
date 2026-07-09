package com.example.logistics.repository;

import java.util.Map;

public interface CustomShipmentRepository {
    Map<String, Object> getShipmentStatsAggregation();
}
