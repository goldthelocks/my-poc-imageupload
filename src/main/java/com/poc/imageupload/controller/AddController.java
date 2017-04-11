/**
 * 
 */
package com.poc.imageupload.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poc.imageupload.dto.UserDto;
import com.poc.imageupload.service.UserService;
import com.poc.imageupload.util.MessageUtil;
import com.poc.imageupload.validator.UserValidator;

/**
 * @author eotayde
 *
 */
@Controller
public class AddController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/add")
	public ModelAndView getAddUser() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new UserDto());
		modelAndView.setViewName("add");
		return modelAndView;
	}

	@GetMapping("/add-success")
	public String getAddUser(Model model) {
		model.addAttribute("successMessage", MessageUtil.getMessage("success.user.added"));		
		return "add-success";
	}
	
	@PostMapping("/add")
	public String processAddUser(@ModelAttribute("user") UserDto userDto, BindingResult results) {
		userValidator.validate(userDto, results);
		
		if (results.hasErrors()) {
			return "add";
		}
		
		userService.save(userDto.getUser());

		return "redirect:add-success";
	}

}
