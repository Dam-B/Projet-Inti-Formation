package fr.formation.inti.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.inti.Iservices.IDepartementService;
import fr.formation.inti.Iservices.IPetService;
import fr.formation.inti.dao.IPetRepository;
import fr.formation.inti.entities.Pet;



@RestController
@RequestMapping("/pets")
public class PetRestController {
	
	@Autowired
	private IPetService petService;
	
	@Autowired
	private IDepartementService deptService;
	
	@Autowired
	private IPetRepository petRepository; 
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Pet> getAll() {
		return petService.findAllPet();
	}
	
	
	@PostMapping("/addPet")
    public ResponseEntity<Pet> createNewCustomer(@RequestBody Pet petRequest) {
        //, UriComponentsBuilder uriComponentBuilder
        Pet existingPet = petService.findByIdpet(petRequest.getIdpet());
        if (existingPet != null) {
            return new ResponseEntity<Pet>(HttpStatus.CONFLICT);
        }
//        petRequest.set(LocalDate.now()); NE PAS OUBLIER DE LE RECUP POUR LE USER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Pet petResponse = petService.save(petRequest);
        if (petResponse != null) {
            return new ResponseEntity<Pet>(petResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<Pet>(HttpStatus.NOT_MODIFIED);
    }

    
    @PutMapping("/updatePet")
    public ResponseEntity<Pet> updateCustomer(@RequestBody Pet petRequest) {
        //, UriComponentsBuilder uriComponentBuilder
        if (!petRepository.existsById(petRequest.getIdpet())) {
            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
        }
        Pet petResponse = petService.update(petRequest);
        if (petResponse != null) {
            return new ResponseEntity<Pet>(petResponse, HttpStatus.OK);
        }
        return new ResponseEntity<Pet>(HttpStatus.NOT_MODIFIED);
    }

    
    @DeleteMapping("/deletePet/{idpet}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer petId) {
        petService.delete(petId);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    /**
     * Retourne le client ayec l'adresse email passée en paramètre.
     * @param email
     * @return
     */
    @GetMapping("/searchByDepartement")
    public ResponseEntity<List<Pet>> searchPetByDepartement(@RequestParam("departement") String departementName) {
        //, UriComponentsBuilder uriComponentBuilder
        List<Pet> pet = petService.findByDepartement(deptService.findbyName(departementName));
        if (pet != null && !CollectionUtils.isEmpty(pet)) {
            return new ResponseEntity<List<Pet>>(pet, HttpStatus.OK);
        }
        return new ResponseEntity<List<Pet>>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * Retourne la liste des clients ayant le nom passé en paramètre.
     * @param lastName
     * @return
     */
    @GetMapping("/searchByLastName")
    public ResponseEntity<List<CustomerDTO>> searchBookByLastName(@RequestParam("lastName") String lastName) {
        //,    UriComponentsBuilder uriComponentBuilder
        List<Customer> customers = customerSe,rvice.findCustomerByLastName(lastName);
        if (customers != null && !CollectionUtils.isEmpty(customers)) {
            List<CustomerDTO> customerDTOs = customers.stream().map(customer -> {
                return mapCustomerToCustomerDTO(customer);
            }).collect(Collectors.toList());
            return new ResponseEntity<List<CustomerDTO>>(customerDTOs, HttpStatus.OK);
        }
        return new ResponseEntity<List<CustomerDTO>>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * Envoie un mail à un client. L'objet MailDTO contient l'identifiant et l'email du client concerné, l'objet du mail et le contenu du message.
     * @param loanMailDto
     * @param uriComponentBuilder
     * @return
     */
    @PutMapping("/sendEmailToCustomer")
    public ResponseEntity<Boolean> sendMailToCustomer(@RequestBody MailDTO loanMailDto, UriComponentsBuilder uriComponentBuilder) {

        Customer customer = customerService.findCustomerById(loanMailDto.getCustomerId());
        if (customer == null) {
            String errorMessage = "The selected Customer for sending email is not found in the database";
            LOGGER.info(errorMessage);
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        } else if (customer != null && StringUtils.isEmpty(customer.getEmail())) {
            String errorMessage = "No existing email for the selected Customer for sending email to";
            LOGGER.info(errorMessage);
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(loanMailDto.MAIL_FROM);
        mail.setTo(customer.getEmail());
        mail.setSentDate(new Date());
        mail.setSubject(loanMailDto.getEmailSubject());
        mail.setText(loanMailDto.getEmailContent());

        try {
            javaMailSender.send(mail);
        } catch (MailException e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

//    /**
//     * Transforme une entity Customer en un POJO CustomerDTO
//     * 
//     * @param customer
//     * @return
//     */
//    private CustomerDTO mapCustomerToCustomerDTO(Customer customer) {
//        ModelMapper mapper = new ModelMapper();
//        CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
//        return customerDTO;
//    }
//
//    /**
//     * Transforme un POJO CustomerDTO en une entity Customer
//     * 
//     * @param customerDTO
//     * @return
//     */
//    private Customer mapCustomerDTOToCustomer(CustomerDTO customerDTO) {
//        ModelMapper mapper = new ModelMapper();
//        Customer customer = mapper.map(customerDTO, Customer.class);
//        return customer;
//    }
}
