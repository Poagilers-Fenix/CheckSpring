package br.com.fiap.epictask.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/user")
	public ModelAndView index() {
		return getUsers();
	}
	
	
	@GetMapping("/user/new")
	public String create(User user) {
		return "user-form";
	}
	
	@PostMapping("/user")
	public Object save(@Valid User user, BindingResult resultUser) {
		if(resultUser.hasErrors()) return "user-form";
		repository.save(user);
		return getUsers();
	}
	
	
	public ModelAndView getUsers() {
		ModelAndView modelAndView = new ModelAndView("users");
		List<User> users = repository.findAll();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
}
