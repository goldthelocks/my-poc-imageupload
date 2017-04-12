package com.poc.imageupload.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.poc.imageupload.dto.Pager;
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
	
	@GetMapping(value="/pictures/user/{id}")
	public String getCustomPicturePage(@PathVariable("id") Long id, HttpServletRequest request) {
		request.getSession().setAttribute("imageList", null);
		return "redirect:/pictures/user/" + id + "/page=1";
	}
	
	@GetMapping(value="/pictures/user/{id}/page={pageNumber}")
	public String getCustomPaginatedPicturePage(@PathVariable("id") Long id, 
			@PathVariable("pageNumber") Integer pageNumber, HttpServletRequest request,
			Model model) {
		
		PagedListHolder<UserUpload> pagedListHolder = (PagedListHolder<UserUpload>) request.getSession().getAttribute("imageList");
		
		User user = userService.findById(id);
		List<UserUpload> pictures = imageUploadService.findByUser(user);
		
		if (pagedListHolder == null) {
			pagedListHolder = new PagedListHolder<UserUpload>();
			pagedListHolder.setSource(pictures);
			pagedListHolder.setPageSize(3);
		} else {
			final int goToPage = pageNumber - 1;
			
			if (goToPage <= pagedListHolder.getPageCount() && goToPage >= 0) {
				pagedListHolder.setPage(goToPage);
			}
		}
		
		request.getSession().setAttribute("imageList", pagedListHolder);
		
		model.addAttribute("pager", currentPage(pagedListHolder, id));
		model.addAttribute("imageList", pagedListHolder);
		
		return "pics";
	}
	
	// without pagination
//	@GetMapping(value="/pictures/user/{id}")
//	public String getCustomPicturePage(@PathVariable("id") Long id, Model model) {
////		User user = userService.findByUsername(username);
//		User user = userService.findById(id);
//		List<UserUpload> pictures = imageUploadService.findByUser(user);
//		model.addAttribute("imageList", pictures);		
//		return "pics";
//	}
	
	@GetMapping(value="/pictures")
	public ModelAndView getPicturePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users", userService.findAll());		
		modelAndView.setViewName("pic-list");
		return modelAndView;
	}
	
	private Pager currentPage(PagedListHolder<?> pagedListHolder, Long id) {
		int currentIndex = pagedListHolder.getPage() + 1;
		int beginIndex = Math.max(1, currentIndex - 3);
		int endIndex = Math.min(beginIndex + 3, pagedListHolder.getPageCount());
		int totalPageCount = pagedListHolder.getPageCount();
		int totalItems = pagedListHolder.getNrOfElements();
		String baseUrl = "/pictures/user/" + id + "/page=";

		Pager pager = new Pager();
		pager.setBeginIndex(beginIndex);
		pager.setEndIndex(endIndex);
		pager.setCurrentIndex(currentIndex);
		pager.setTotalPageCount(totalPageCount);
		pager.setTotalItems(totalItems);
		pager.setBaseUrl(baseUrl);
		return pager;
	}

}
