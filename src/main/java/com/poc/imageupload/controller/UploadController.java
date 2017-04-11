/**
 * 
 */
package com.poc.imageupload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poc.imageupload.dto.ImageUploadDto;
import com.poc.imageupload.model.User;
import com.poc.imageupload.service.ImageUploadService;
import com.poc.imageupload.service.UserService;
import com.poc.imageupload.validator.ImageUploadValidator;

/**
 * @author eotayde
 *
 */
@Controller
public class UploadController {

	@Autowired
	private UserService userService;

	@Autowired
	private ImageUploadService imageUploadService;

	@Autowired
	private ImageUploadValidator imageUploadValidator;

	@GetMapping("/upload")
	public ModelAndView getUploadPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("imageUpload", new ImageUploadDto());
		modelAndView.setViewName("upload");
		return modelAndView;
	}
	
	@GetMapping("/upload-done")
	public String getUploadDonePage() {
		return "upload-done";
	}

	@PostMapping("/upload")
	public String getUploadFilePage(@ModelAttribute("imageUpload") ImageUploadDto imageUploadDto,
			BindingResult results) {

		imageUploadValidator.validate(imageUploadDto, results);

		try {

			if (results.hasErrors()) {
				return "upload";
			}

			User userFromDao = userService.findByUsername(imageUploadDto.getUser().getUsername());
			imageUploadService.saveImages(userFromDao, imageUploadDto.getUploadedPictures());
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		return "redirect:upload-done";
	}
}
