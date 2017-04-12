package com.poc.imageupload.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.poc.imageupload.model.User;
import com.poc.imageupload.model.UserUpload;
import com.poc.imageupload.service.ImageUploadService;
import com.poc.imageupload.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageUploadService imageUploadService;
	
	@GetMapping(value="/")
	public ModelAndView getHomePage(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@GetMapping(value="/pictures/{username}")
	public String getCustomPicturePage(@PathVariable("username") String username, Model model) {
		User user = userService.findByUsername(username);
		List<UserUpload> pictures = imageUploadService.findByUser(user);
		model.addAttribute("imageList", pictures);		
		return "pics";
	}
	
	@GetMapping(value="/pictures")
	public ModelAndView getPicturePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users", userService.findAll());		
		modelAndView.setViewName("pic-list");
		return modelAndView;
	}

}
