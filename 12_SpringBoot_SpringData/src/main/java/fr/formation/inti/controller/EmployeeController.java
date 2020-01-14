package fr.formation.inti.controller;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
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
import org.springframework.web.util.UriComponentsBuilder;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.entities.User;
import fr.formation.inti.pageable.PaginationResult;
import fr.formation.inti.services.IEmployeService;
 
@Controller
@RequestMapping("/employee")
@SessionAttributes("employees")
public class EmployeeController {
	
	
	@Autowired
	private IEmployeService employeeService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
//	  @RequestMapping(value = { "/admin/orderList" }, method = RequestMethod.GET)
//	   public String orderList(Model model, //
//	         @RequestParam(value = "page", defaultValue = "1") String pageStr) {
//	      int page = 1;
//	      try {
//	         page = Integer.parseInt(pageStr);
//	      } catch (Exception e) {
//	      }
//	      final int MAX_RESULT = 5;
//	      final int MAX_NAVIGATION_PAGE = 10;
//	 
//	      PaginationResult<Employee> paginationResult //
//	            = employeeService.listOrderInfo(page, MAX_RESULT, MAX_NAVIGATION_PAGE);
//	 
//	      model.addAttribute("paginationResult", paginationResult);
//	      return "orderList";
//	   }
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap) {
		List<Employee> employees = (List<Employee>) employeeService.findAllEmployes();
		PagedListHolder<Employee> pagedListHolder = new PagedListHolder<Employee>(employees);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "employees";
	}
 
//	@GetMapping("/list")
//    public String getAllEmployes(Model theModel,
//    @RequestParam(defaultValue="0") Integer Nopage
//    ,@RequestParam(defaultValue="10") Integer PageSize
//    ,@RequestParam(defaultValue="empId") String sortBy
//    ) {
//        List<Employee> employees = employeeService.getAllEmployees(Nopage, PageSize, sortBy);
//        theModel.addAttribute("employees", employees);
//        return "employees";
//    }
	 @RequestMapping("/login")
	    public String loginFormForAdd(Model theModel) {
	        User user = new User();
	        theModel.addAttribute("user", user);
	        return "login";
	    }
    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Employee emp = new Employee();
        theModel.addAttribute("employee", emp);
        return "employee-form";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee emp) {
    	if(emp.getEmpId() != null)
    		employeeService.modifierEmploye(emp);
    	else
    		employeeService.ajouterEmploye(emp);
        return "redirect:/employee/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("empId") int empId,
        Model theModel) {
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