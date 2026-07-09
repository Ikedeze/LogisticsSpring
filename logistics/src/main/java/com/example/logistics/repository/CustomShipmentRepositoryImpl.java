package com.example.logistics.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;

import java.util.Map;

public class CustomShipmentRepositoryImpl implements
        CustomShipmentRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Map<String, Object> getShipmentStatsAggregation(){
        // Build the pipeline stages

        // Stage 1: Group by status and count them
        GroupOperation groupByStatus = Aggregation.group("status").
                count().
                as("total");

        // Stage 2: Project the final structural shape we want
        ProjectionOperation projectStage = Aggregation.project()
                .andExpression("_id").as("status")
                .and("total").as("total");

        Aggregation aggregation = Aggregation.newAggregation(groupByStatus,projectStage);

        // Execute against the "shipments" collection
        AggregationResults<Document> results = mongoTemplate.aggregate(
                aggregation, "shipment", Document.class
        );

        // For now, let's just return the raw mapped results
        //   list wrapped in a container map
        return Map.of("stats", results.getMappedResults());
    }
}
