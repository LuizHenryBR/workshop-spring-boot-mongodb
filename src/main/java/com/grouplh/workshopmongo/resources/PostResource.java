package com.grouplh.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grouplh.workshopmongo.domain.Post;
import com.grouplh.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired 											//Spring Boot dependency injection mechanism. Automatically instantiates the object
	private PostService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
