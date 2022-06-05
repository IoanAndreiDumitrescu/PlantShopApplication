package com.andrei.plantshop.repository;


import com.andrei.plantshop.entities.Pot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PotRepository extends JpaRepository<Pot, Long> {
    List<Pot> findByName(String name);
}
