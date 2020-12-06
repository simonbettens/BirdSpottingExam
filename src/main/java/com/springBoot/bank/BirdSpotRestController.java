package com.springBoot.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.BirdSpotLocation;
import domain.SpottedBird;
import service.SpottedBirdService;

@RestController()
@RequestMapping(value = "/birds-spotted")
public class BirdSpotRestController
{
	@Autowired
	private SpottedBirdService spottedBirdService; 
	
	@GetMapping(value = "/{name}") 
    public List<SpottedBird> getDummyEmployee(@PathVariable("name") String name) {
		Optional<BirdSpotLocation> bsl = spottedBirdService.findByName(name);
		if(bsl.isEmpty() ) {
			return new ArrayList<SpottedBird>();
		}
        return bsl.get().getSpottedBirds() ;
    }
}
