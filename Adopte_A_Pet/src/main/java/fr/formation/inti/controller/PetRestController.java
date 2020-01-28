package fr.formation.inti.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.inti.Registration;
import fr.formation.inti.RegistrationPet;
import fr.formation.inti.Iservices.ICategorieService;
import fr.formation.inti.Iservices.IDepartementService;
import fr.formation.inti.Iservices.IPetService;
import fr.formation.inti.dao.IPetRepository;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.entities.User;



@RestController
@RequestMapping("/pets")
public class PetRestController {
	
	@Autowired
	private IPetService petService;
	
	@Autowired
	private IDepartementService deptService;
	
	@Autowired
	private ICategorieService categorieService;
	
	@Autowired
	private IPetRepository petRepository; 
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Pet> getAll() {
		return petService.findAllPet();
	}
	
	
	@PostMapping("/addPet")
    public ResponseEntity<Pet> createNewPet(@RequestBody RegistrationPet petData) {
        //, UriComponentsBuilder uriComponentBuilder
		Pet existingPet = petService.findByName(petData.getName());
        if (existingPet != null) {
            return new ResponseEntity<Pet>(HttpStatus.CONFLICT);
        }
//        petRequest.set(LocalDate.now()); NE PAS OUBLIER DE LE RECUP POUR LE USER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Pet petRequest = new Pet(petData.getName(),petData.getRace(),petData.getAge());
        Pet petResponse = petService.save(petRequest);
        if (petResponse != null) {
            return new ResponseEntity<Pet>(petResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<Pet>(HttpStatus.NOT_MODIFIED);
    }

    
    @PutMapping("/updatePet")
    public ResponseEntity<Pet> updatePet(@RequestBody RegistrationPet petRequest) {
        //, UriComponentsBuilder uriComponentBuilder
        if (!petRepository.existsById(Integer.parseInt(petRequest.getIdPet()))) {
            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
        }
        Pet pet = new Pet(petRequest.getName(),petRequest.getRace(),petRequest.getAge());
        Pet petResponse = petService.update(pet);
        if (petResponse != null) {
            return new ResponseEntity<Pet>(petResponse, HttpStatus.OK);
        }
        return new ResponseEntity<Pet>(HttpStatus.NOT_MODIFIED);
    }

    
    @DeleteMapping("/deletePet/{idpet}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String idpet) {
           petService.delete(Integer.parseInt(idpet));
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/searchByDepartement")
    public ResponseEntity<List<Pet>> searchPetByDepartement(@RequestParam("departement") String departementName) {
        //, UriComponentsBuilder uriComponentBuilder
        List<Pet> pet = petService.findByDepartement(deptService.findbyName(departementName));
        if (pet != null && !CollectionUtils.isEmpty(pet)) {
            return new ResponseEntity<List<Pet>>(pet, HttpStatus.OK);
        }
        return new ResponseEntity<List<Pet>>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/searchByCategorie")
    public ResponseEntity<List<Pet>> searchPetByCategorie(@RequestParam("categorie") String categorieName) {
        //, UriComponentsBuilder uriComponentBuilder
        List<Pet> pet = petService.findByCategorie(categorieService.findByCategorie(categorieName));
        if (pet != null && !CollectionUtils.isEmpty(pet)) {
            return new ResponseEntity<List<Pet>>(pet, HttpStatus.OK);
        }
        return new ResponseEntity<List<Pet>>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/searchById/{idpet}")
    public ResponseEntity<Pet> searchPetById(@PathVariable String idpet) {
        //, UriComponentsBuilder uriComponentBuilder
        Pet pet = petService.findByIdpet(Integer.parseInt(idpet));
        if (pet != null) {
            return new ResponseEntity<Pet>(pet, HttpStatus.OK);
        }
        return new ResponseEntity<Pet>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/countPet")
    public ResponseEntity<Long> countPet() { 
    	long nbpet = petRepository.count();
        return new ResponseEntity<Long>(nbpet,HttpStatus.OK);
    } 

   
   
}
