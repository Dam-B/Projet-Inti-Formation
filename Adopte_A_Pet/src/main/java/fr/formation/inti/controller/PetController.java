package fr.formation.inti.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.formation.inti.Iservices.IPetService;
import fr.formation.inti.Iservices.ISecurityService;
import fr.formation.inti.Iservices.IUserService;
import fr.formation.inti.dao.IUserRepository;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.validation.UserValidator;

@Controller
@RequestMapping("/pet")
@SessionAttributes("pets")
public class PetController {
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IUserService userService;

	@Autowired
	private ISecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private IPetService petService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index2(HttpServletRequest request, ModelMap modelMap) {
		List<Pet> pet = petService.findAllPet();
		PagedListHolder<Pet> pagedListHolder = new PagedListHolder<Pet>(pet);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("pets", pagedListHolder);
		return "pets";
	}

//	@GetMapping
//    public ResponseEntity<List<Employee>> getAllEmployees(
//                        @RequestParam(defaultValue = "0") Integer pageNo, 
//                        @RequestParam(defaultValue = "10") Integer pageSize,
//                        @RequestParam(defaultValue = "empId") String sortBy) 
//    {
//        List<Employee> list = employeeService.getAllEmployees(pageNo, pageSize, sortBy);
// 
//        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK); 
//    }
//	@GetMapping
//	public String getAllEmployees(Model model, @RequestParam(defaultValue = "0") Integer pageNo,
//			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "empId") String sortBy) {
//		List<Employee> list = employeeService.getAllEmployees(pageNo, pageSize, sortBy);
//		model.addAttribute("employees", list);
//
//		return "employees";
//	}

	@RequestMapping("/list3")
	public String viewemp(Model m, Pageable pageable, 
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "empId") String sortBy) {
		List<Pet> list = petService.getAllPet(pageNo, pageSize, sortBy);
		m.addAttribute("employees", list);
		Page<Pet> pages = petService.getPage(pageable);
		m.addAttribute("number", pages.getNumber());
		m.addAttribute("totalPages", pages.getTotalPages());
		m.addAttribute("totalElements", pages.getTotalElements());
		m.addAttribute("size", pages.getSize());
		m.addAttribute("data", pages.getContent());
		return "pets";
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap) {
		List<Pet> pet= (List<Pet>) petService.findAllPet();
		PagedListHolder<Pet> pagedListHolder = new PagedListHolder<Pet>(pet);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "pets";
	}

	@GetMapping("/list2")
	public String listCustomers(Model theModel) {
		List<Pet> pet = petService.findAllPet();
		theModel.addAttribute("pets", pet);
		return "pets";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Pet pet = new Pet();
		theModel.addAttribute("pet", pet);
		return "pet-form";
	}

	@PostMapping("/savePet")
	public String savePet(@ModelAttribute("pet") Pet pet) {
		if (pet.getIdpet() != null)
			petService.update(pet);
		else
			petService.save(pet);
		return "redirect:/pet/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("idpet") int idpet, Model theModel) {
		Pet pet = petService.findByIdpet(idpet);
		theModel.addAttribute("pet", pet);
		return "pet-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("idpet") Integer idpet) {
		petService.delete(idpet);
		return "redirect:/pet/list";
	}

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("pets")
	public List<Pet> initializeManager() {
		List<Pet> list = petService.findAllPet();
		return list;
	}

	
}
