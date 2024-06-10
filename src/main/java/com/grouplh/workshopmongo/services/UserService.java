package com.grouplh.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouplh.workshopmongo.domain.User;
import com.grouplh.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired //Spring Boot dependency injection mechanism. Automatically instantiates the object
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll(); //Using the findAll() method from UserRepository interface because it extends the MongoRepository interface
	}
}
