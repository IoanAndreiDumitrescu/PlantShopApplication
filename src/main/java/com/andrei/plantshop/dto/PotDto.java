package com.andrei.plantshop.dto;

import com.andrei.plantshop.entities.Pot;
import java.util.ArrayList;
import java.util.List;


public class PotDto {
    private Long id;
    private String name;
    private String description;
    private List<Pot> potList = new ArrayList<>();

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

    public List<Pot> getPotList() {
        return potList;
    }

    public void setPotList(List<Pot> potList) {
        this.potList = potList;
    }
}
