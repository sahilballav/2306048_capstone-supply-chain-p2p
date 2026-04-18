package com.kiit.supplychain.p2p_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer currentStock;
    private Integer minimumThreshold;

    public Material() {
    }

    public Material(String name, Integer currentStock, Integer minimumThreshold) {
        this.name = name;
        this.currentStock = currentStock;
        this.minimumThreshold = minimumThreshold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getMinimumThreshold() {
        return minimumThreshold;
    }

    public void setMinimumThreshold(Integer minimumThreshold) {
        this.minimumThreshold = minimumThreshold;
    }
}