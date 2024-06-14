package com.grouplh.workshopmongo.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
