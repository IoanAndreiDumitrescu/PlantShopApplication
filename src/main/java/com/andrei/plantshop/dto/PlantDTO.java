package com.andrei.plantshop.dto;

import com.andrei.plantshop.entities.Plant;

import java.util.ArrayList;
import java.util.List;

public class PlantDTO {
    private Long id;

    private String name;

    private String description;
    private List<Plant> plantList = new ArrayList<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
    }
}
