package com.grouplh.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouplh.workshopmongo.domain.Post;
import com.grouplh.workshopmongo.repository.PostRepository;
import com.grouplh.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired //Spring Boot dependency injection mechanism. Automatically instantiates the object
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("ERROR, object not found")); //Verifies if obj is null. When null throws the exception, when has a value return it
	}
	
}
