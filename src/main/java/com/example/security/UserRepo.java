package com.example.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long>{
	public Optional<User> findByUsername(String username);
}
