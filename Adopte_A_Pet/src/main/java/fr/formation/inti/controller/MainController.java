package fr.formation.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.formation.inti.Iservices.IUserService;
import fr.formation.inti.dao.IDepartementRepository;
import fr.formation.inti.dao.ITitleRepository;
import fr.formation.inti.dao.IUserRepository;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Title;
import fr.formation.inti.entities.User;
 
@Controller
public class MainController {
	@Autowired
    private IUserService userService;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IDepartementRepository deptRepository;
    @Autowired
    private ITitleRepository titleRepository;
    
    private User user;
    private static final String[] NAMES = new String[] { "Tom", "Jerry", "Donald" };
 
    @ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/testInsert'>Test Insert</a></li>";
        html += " <li><a href='/showAllEmployee'>Show All Employee</a></li>";
        html += " <li><a href='/showByIDSEARCH'>Show By ID search 'Tom'</a></li>";
        html += " <li><a href='/deleteAllEmployee'>Delete All Employee</a></li>";
        html += "</ul>";
        return html;
    }
 
    @ResponseBody
    @RequestMapping("/testInsert")
    public String testInsert() {
    	Departement dept = deptRepository.findByDeptid(1);
		Title title = titleRepository.findByIdtitle(1);
		user= new User(dept, title, "Dam", "12");
		userService.save(user);
		boolean b  = userRepository.existsById(user.getIduser());
 
        return "Inserted: " + user +" "+ b;
    }
 
    @ResponseBody
    @RequestMapping("/showAllEmployee")
    public String showAllEmployee() {
 
        Iterable<User> employees = this.userRepository.findAll();
 
        String html = "";
        for (User emp : employees) {
            html += emp + "<br>";
        }
 
        return html;
    }
 
    @ResponseBody
    @RequestMapping("/showByIDSEARCH")
    public String showFullNameLikeTom() {
 
        User usr = userRepository.findByIduser(1);
        String html = "";
        html += usr + "<br>";
        return html;
    }
 
 
}
