package com.andrei.plantshop.controller;

import com.andrei.plantshop.dto.PotDto;
import com.andrei.plantshop.entities.Pot;
import com.andrei.plantshop.service.PotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/pot")
public class PotController {

    @Autowired
    private PotService potService;

    @GetMapping("/")
    public String showPotPage(Model model) {
        List<Pot> potList = potService.findAll();
        model.addAttribute("potsInView", potList);
        return "flower-pot-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Pot newPot = new Pot();
        model.addAttribute("pot", newPot);
        return "flower-pot-add";
    }

    @PostMapping("/add")
    public String addNewPot(@ModelAttribute("pot") @Valid Pot pot, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "flower-pot-add";
        }
        potService.save(pot);
        return "redirect:/pot/";
    }

    @GetMapping("/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        model.addAttribute("pot", potService.findById(id));
        return "flower-pot-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute PotDto potDto) {
        potService.update(id, potDto);
        return "redirect:/pot/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        potService.delete(id);
        return "redirect:/pot/";
    }
}