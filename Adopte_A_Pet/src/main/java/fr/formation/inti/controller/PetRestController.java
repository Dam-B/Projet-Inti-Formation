package fr.formation.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.inti.Iservices.IPetService;
import fr.formation.inti.entities.Pet;



@RestController
@RequestMapping("/pets")
public class PetRestController {
	
	@Autowired
	private IPetService petService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Pet> getAll() {
		return petService.findAllPet();
	}
	
	
	@RequestMapping(value = "{petId}", method = RequestMethod.PUT, produces = "application/json")
	public Pet updatePet() {
		Pet pet = new Pet();
		
		return petService.update(pet);
	}
}
