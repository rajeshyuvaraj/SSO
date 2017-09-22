package com.rajeshyuvaraj.common.controller;

import java.security.Principal;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Single Singon welcomes you...!!");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		   System.err.println(" currentUserName :::"+currentUserName);
		   System.err.println(authentication.getCredentials());
		}
		return "welcome";
	}
}