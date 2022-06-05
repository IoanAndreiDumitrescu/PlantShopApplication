package com.andrei.plantshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"", "/", "index"})
    public String getIndex() {
        return "fragments/index";
    }

    @RequestMapping("/plant")
    public String getPlant() {
        return "plant";
    }

    @RequestMapping("/pot")
    public String getPot() {
        return "flower-pot";
    }

    @RequestMapping("/contact")
    public String getContact() {
        return "contact";
    }

    @RequestMapping("/tropical")
    public String getTropical() {
        return "tropical";
    }

    @RequestMapping("/offers")
    public String getOffers() {
        return "offers";
    }

    @RequestMapping("/add")
    public String getPlantAdd() {
        return "plant-add";
    }

    @RequestMapping("/edit")
    public String getPlantEdit() {
        return "plant-edit";
    }

    @RequestMapping("/pot/edit")
    public String getPotEdit() {
        return "flower-pot-edit";
    }

    @RequestMapping("/pot/add")
    public String getPotAdd() {
        return "flower-pot-add";
    }
}
