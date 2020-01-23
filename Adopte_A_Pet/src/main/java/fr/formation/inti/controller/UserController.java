package fr.formation.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.formation.inti.Iservices.ISecurityService;
import fr.formation.inti.Iservices.IUserService;
import fr.formation.inti.dao.IUserRepository;
import fr.formation.inti.entities.User;
import fr.formation.inti.validation.UserValidator;

@Controller
public class UserController {
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IUserService userService;

	@Autowired
	private ISecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		userService.save(userForm);
		securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";

	}

	@PostMapping("/logout")
	public String logout(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";
	}

	@RequestMapping(value = "/Users", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<User> getUsers() {
		List<User> list = userRepository.findAll();
		return list;
	}

	@RequestMapping(value = "/User/{iduser}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public User getUser(@PathVariable("iduser") Integer iduser) {
		return userService.findByIduser(iduser);
	}

	@RequestMapping(value = "/User", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public Integer addEmployee(@RequestBody User user) {
		user.getIduser();
		return userService.save(user);
	}

	@RequestMapping(value = "/User/{iduser}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public void deleteUser(@PathVariable("iduser") Integer iduser) {
		userService.delete(iduser);
	}

	@RequestMapping(value = "/UpdateUser", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public void modifierUser(@RequestBody User user) {
		userService.update(user);
	}

}
