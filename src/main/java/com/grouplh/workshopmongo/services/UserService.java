package com.grouplh.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouplh.workshopmongo.domain.User;
import com.grouplh.workshopmongo.dto.UserDTO;
import com.grouplh.workshopmongo.repository.UserRepository;
import com.grouplh.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired //Spring Boot dependency injection mechanism. Automatically instantiates the object
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll(); //Using the findAll() method from UserRepository interface because it extends the MongoRepository interface
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("ERROR, object not found")); //Verifies if obj is null. When null throws the exception, when has a value return it
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
