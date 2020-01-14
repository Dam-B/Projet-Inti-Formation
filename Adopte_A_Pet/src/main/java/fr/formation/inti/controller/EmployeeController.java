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
import org.springframework.validation.BindingResult;
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

import fr.formation.inti.entities.Employee;
import fr.formation.inti.services.IEmployeService;
import fr.formation.inti.validation.FormValidator;

@Controller
@RequestMapping("/employee")
@SessionAttributes("employees")
public class EmployeeController {

	@Autowired
	private IEmployeService employeeService;
	
	@Autowired
	private FormValidator valideremployee;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index2(HttpServletRequest request, ModelMap modelMap) {
		List<Employee> employees = (List<Employee>) employeeService.findAllEmployes();
		PagedListHolder<Employee> pagedListHolder = new PagedListHolder<Employee>(employees);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("employees", pagedListHolder);
		return "employees";
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
		List<Employee> list = employeeService.getAllEmployees(pageNo, pageSize, sortBy);
		m.addAttribute("employees", list);
		Page<Employee> pages = employeeService.getPage(pageable);
		m.addAttribute("number", pages.getNumber());
		m.addAttribute("totalPages", pages.getTotalPages());
		m.addAttribute("totalElements", pages.getTotalElements());
		m.addAttribute("size", pages.getSize());
		m.addAttribute("data", pages.getContent());
		return "employees";
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap) {
		List<Employee> employees= (List<Employee>) employeeService.findAllEmployes();
		PagedListHolder<Employee> pagedListHolder = new PagedListHolder<Employee>(employees);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "employees";
	}

	@GetMapping("/list2")
	public String listCustomers(Model theModel) {
		List<Employee> employees = employeeService.findAllEmployes();
		theModel.addAttribute("employees", employees);
		return "employees";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Employee emp = new Employee();
		theModel.addAttribute("employee", emp);
		return "employee-form";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp, BindingResult bindingResult) {
		valideremployee.validate(emp, bindingResult);
		if (emp.getEmpId() != null)
			employeeService.modifierEmploye(emp);
		else {
			if(bindingResult.hasErrors())
				return "employee-form";
			else {
				employeeService.ajouterEmploye(emp);
				return "redirect:/employee/list";
			}
		}
		return "employee-form";		
		
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("empId") int empId, Model theModel) {
		Employee emp = employeeService.findEmployeById(empId);
		theModel.addAttribute("employee", emp);
		return "employee-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("empId") Integer empId) {
		employeeService.supprimerEmploye(empId);
		return "redirect:/employee/list";
	}

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("employees")
	public List<Employee> initializeManager() {
		List<Employee> list = employeeService.findAllEmployes();
		return list;
	}
}