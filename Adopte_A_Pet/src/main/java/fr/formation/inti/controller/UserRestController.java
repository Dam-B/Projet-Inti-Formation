package fr.formation.inti.controller;

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

import fr.formation.inti.Iservices.IDepartementService;
import fr.formation.inti.Iservices.ITitleService;
import fr.formation.inti.Iservices.IUserService;
import fr.formation.inti.dao.IUserRepository;
import fr.formation.inti.entities.User;



@RestController
@RequestMapping("/User")
public class UserRestController {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ITitleService titleService;
	
	@Autowired
	private IDepartementService deptService;
	
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	
	@PostMapping("/addUser")
    public ResponseEntity<User> createNewUser(@RequestBody User userRequest) {
        //, UriComponentsBuilder uriComponentBuilder
        User existingUser = userService.findByIduser(userRequest.getIduser());
        if (existingUser != null) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
//        petRequest.set(LocalDate.now()); NE PAS OUBLIER DE LE RECUP POUR LE USER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        User userResponse = userService.save(userRequest);
        if (userResponse != null) {
            return new ResponseEntity<User>(userResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_MODIFIED);
    }

    
    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User userRequest) {
        //, UriComponentsBuilder uriComponentBuilder
        if (!userRepository.existsById(userRequest.getIduser())) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        User userResponse = userService.update(userRequest);
        if (userResponse != null) {
            return new ResponseEntity<User>(userResponse, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_MODIFIED);
    }

    
    @DeleteMapping("/deleteUser/{iduser}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer userId) {
        userService.delete(userId);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/searchByDepartement")
    public ResponseEntity<List<User>> searchUserByDepartement(@RequestParam("departement") String departementName) {
        //, UriComponentsBuilder uriComponentBuilder
        List<User> user = userService.findByDepartement(deptService.findbyName(departementName));
        if (user != null && !CollectionUtils.isEmpty(user)) {
            return new ResponseEntity<List<User>>(user, HttpStatus.OK);
        }
        return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/searchByTitle")
    public ResponseEntity<List<User>> searchByUserTitle(@RequestParam("title") Integer idTitle) {
        //, UriComponentsBuilder uriComponentBuilder
        List<User> user = userService.findByTitle(titleService.findByIdtitle(idTitle));
        if (user != null && !CollectionUtils.isEmpty(user)) {
            return new ResponseEntity<List<User>>(user, HttpStatus.OK);
        }
        return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/searchById/{iduser}")
    public ResponseEntity<User> searchPetById(@PathVariable Integer userid) {
        //, UriComponentsBuilder uriComponentBuilder
        User user = userService.findByIduser(userid);
        if (user != null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

   
   
}
