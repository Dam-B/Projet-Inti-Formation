package fr.formation.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpringBootController {
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("message","Hello Spring Boot 2.2.2 !");
		return "hello";
	}

}
