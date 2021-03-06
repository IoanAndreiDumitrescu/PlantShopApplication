package com.andrei.plantshop.repository;
import com.andrei.plantshop.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    List<Plant> findByName(String name);
}
