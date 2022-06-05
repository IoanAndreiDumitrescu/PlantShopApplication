package com.andrei.plantshop.service;


import com.andrei.plantshop.dto.PotDto;
import com.andrei.plantshop.entities.Pot;
import com.andrei.plantshop.repository.PotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PotService {
    private PotRepository potRepository;

    @Autowired
    public PotService(PotRepository potRepository) {
        this.potRepository = potRepository;
    }

    public List<Pot> findAll() {
        return potRepository.findAll();
    }
    public Pot findById(Long id) {
        return potRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Flower pot not found"));
    }

    public void update(Long id, PotDto potDto) {
        potRepository.findById(id)
                .map(existingPot -> updateEntity(potDto, existingPot))
                .map(updatedPot -> potRepository.save(updatedPot))
                .orElseThrow(() -> new RuntimeException("Flower pot not found"));
    }

    private Pot updateEntity(PotDto potDto, Pot existingPot) {
        existingPot.setName(potDto.getName());
        existingPot.setDescription(potDto.getDescription());

        return existingPot;
    }

    @Transactional
    public void delete(Long id) {
        potRepository.deleteById(id);
    }

    public void save(Pot pot) {
        potRepository.save(pot);
    }
}
