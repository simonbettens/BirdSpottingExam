package com.springBoot.bank;

import java.time.Year;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.BirdSpecie;
import domain.BirdSpotLocation;
import service.SpottedBirdService;
import validator.BirdSpecieValidator;

@Controller
@RequestMapping("/birdspotting")
public class BirdSpottingController {
	
	@Autowired
	private SpottedBirdService spottedBirdService; 
	
	@Autowired
	private BirdSpecieValidator validator;
	
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
	
	@GetMapping(value="/{name}/newbirdspotting")
	public String getForm( @PathVariable("name") String name,Model model) {
		BirdSpecie bs = new BirdSpecie("Specie", Year.now().getValue(), "AA000");
		model.addAttribute("birdSpecie", bs);
		model.addAttribute("name", name);
		return "createSpecie";
	}
	
	@PostMapping(value="/{name}/newbirdspotting")
	public String postFrom(@PathVariable("name") String name, @Valid BirdSpecie birdSpecie, BindingResult bindingResult, Model model,  Locale locale ) {
		validator.validate(birdSpecie, bindingResult);
		if(bindingResult.hasErrors()) {
			model.addAttribute("message","Please review entered data...");
			return "createSpecie";
		}
		BirdSpotLocation bsl = spottedBirdService.findByName(name).get();
        bsl.increaseBirdSpot(birdSpecie);
        
		return "redirect:/birdspotting/"+name;
	}

}
