package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.RegistroService;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private RegistroService registroService;


	@GetMapping
	public String registration(@AuthenticationPrincipal User usuario) {
		if (usuario != null)
			return "archivos";
		return "registro";
	}

	@PostMapping
	public String registrar(User usuario) {
		registroService.registrar(usuario);
		return "archivos";
	}
}
