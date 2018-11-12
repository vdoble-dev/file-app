package com.example.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

	@GetMapping
	public String login(@AuthenticationPrincipal User user) {
		if (user != null)
			return "redirect:/";
		
		return "index";
	}
	
}
