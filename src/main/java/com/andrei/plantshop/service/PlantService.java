package com.andrei.plantshop.service;

import com.andrei.plantshop.dto.PlantDTO;
import com.andrei.plantshop.entities.Plant;
import com.andrei.plantshop.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlantService {
    private PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> findAll() {
        return plantRepository.findAll();
    }
    public Plant findById(Long id) {
        return plantRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Plant not found"));
    }

    public void update(Long id, PlantDTO plantDTO) {
        plantRepository.findById(id)
                .map(existingPlant -> updateEntity(plantDTO, existingPlant))
                .map(updatedPlant -> plantRepository.save(updatedPlant))
                .orElseThrow(() -> new RuntimeException("Plant not found"));
    }

    private Plant updateEntity(PlantDTO plantDTO, Plant existingPlant) {
        existingPlant.setName(plantDTO.getName());
        existingPlant.setDescription(plantDTO.getDescription());

        return existingPlant;
    }

    @Transactional
    public void delete(Long id) {
        plantRepository.deleteById(id);
    }

    public void save(Plant plant) {
        plantRepository.save(plant);
    }


}
