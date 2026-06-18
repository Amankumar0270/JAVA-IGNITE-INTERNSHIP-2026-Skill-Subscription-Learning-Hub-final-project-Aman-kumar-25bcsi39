package com.skills.hub.controller;

import com.skills.hub.model.SkillPack;
import com.skills.hub.service.SkillPackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
=========================================================
WHAT IS THIS FILE?
Handles skill pack (course) operations
=========================================================
*/

@Controller
public class SkillPackController {

    private final SkillPackService packService;

    public SkillPackController(SkillPackService packService) {
        this.packService = packService;
    }

    @GetMapping("/packs")
    public String viewPacks(Model model) {
        model.addAttribute("packs", packService.getAllPacks());
        return "packs";
    }

    @GetMapping("/add-pack")
    public String showAddPackPage() {
        return "add-pack";
    }

    @PostMapping("/add-pack")
    public String addPack(@ModelAttribute SkillPack pack) {
        packService.addSkillPack(pack);
        return "redirect:/packs";
    }

    @GetMapping("/edit-pack/{id}")
    public String showEditPackPage(@PathVariable Long id, Model model) {
        SkillPack pack = packService.getAllPacks().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().orElse(null);
        model.addAttribute("editPack", pack);
        model.addAttribute("packs", packService.getAllPacks());
        return "packs";
    }

    @PostMapping("/update-pack")
    public String updatePack(@ModelAttribute SkillPack pack) {
        packService.updateSkillPack(pack);
        return "redirect:/packs";
    }

    @GetMapping("/delete-pack/{id}")
    public String deletePack(@PathVariable Long id) {
        packService.deleteSkillPack(id);
        return "redirect:/packs";
    }

	public SkillPackService getPackService() {
		return packService;
	}
}