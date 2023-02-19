package com.andrei.plantshop.controller;

import com.andrei.plantshop.dto.PlantDTO;
import com.andrei.plantshop.entities.Plant;
import com.andrei.plantshop.service.PlantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/plant")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/")
    public String showPlantsPage(Model model) {
        List<Plant> plantList = plantService.findAll();
        model.addAttribute("plantsInView", plantList);
        return "plant-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Plant newPlant = new Plant();
        model.addAttribute("plant", newPlant);
        return "plant-add";
    }
    @PostMapping("/add")
    public String addNewPlant(@ModelAttribute("plant")@Valid Plant plant, BindingResult bindingResult) {
      if (bindingResult.hasErrors()) {
          return "plant-add";
      }
      plantService.save(plant);
      return "redirect:/plant/";
    }

    @GetMapping("/{id}/edit")
    public String editForm(Model model,@PathVariable Long id) {
        model.addAttribute("plant",plantService.findById(id));
        return "plant-edit";
    }
    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute PlantDTO plantDTO) {
        plantService.update(id, plantDTO);
        return "redirect:/plant/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        plantService.delete(id);
        return "redirect:/plant/";
    }
}
