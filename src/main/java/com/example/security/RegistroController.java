package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passEnconder;

	@GetMapping
	public String registration(@AuthenticationPrincipal User user) {
		if (user != null)
			return "redirect:/";
		return "registro";
	}

	@PostMapping
	public String registrar(User user) {
		user.setPassword(passEnconder.encode(user.getPassword()));
		userRepo.save(user);
		return "redirect:/login";
	}
}
