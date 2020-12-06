package com.springBoot.bank;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.BirdSpotLocation;
import service.SpottedBirdService;

@Controller
@RequestMapping("/birdspotting")
public class BirdSpottingController {
	
	@Autowired
	private SpottedBirdService spottedBirdService; 
	
	
	@GetMapping
	public String getOverview(Model model) {
		List<BirdSpotLocation> list = spottedBirdService.findAll();
		model.addAttribute("birdSpotLocationList", list);
		return "overviewLocations";
	
	}
	
	@GetMapping(value="/{name}")
    public String show( @PathVariable("name") String name, Model model) {
		Optional<BirdSpotLocation> bsl = spottedBirdService.findByName(name);
         if (bsl.isEmpty()) {
        	return "redirect:/";
        }
        model.addAttribute("birdSpotLocation", bsl.get());
        return "overviewLocation";
    }

}
