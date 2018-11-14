package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.User;
import com.example.security.UserRepo;
import com.example.service.RegistroService;

@Service
public class RegistroServiceImpl implements RegistroService {

	@Autowired
	private PasswordEncoder passEnconder;
	
	@Autowired
	private UserRepo repo;
	
	@Override
	public void registrar(User usuario) {
		usuario.setPassword(passEnconder.encode(usuario.getPassword()));
		repo.save(usuario);
	}

}
