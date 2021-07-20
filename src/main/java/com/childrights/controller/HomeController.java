package com.childrights.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@RestController
//@RequestMapping("/rest/auth")
@Controller
public class HomeController {

	@GetMapping("")
	public String home() {
		return "admin/home";
	}
	
	@GetMapping("/login")
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth==null || auth instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "redirect:/";
	}
	
}
