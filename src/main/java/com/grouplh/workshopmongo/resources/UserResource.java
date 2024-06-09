package com.grouplh.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grouplh.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	// @GetMapping <-works like that too
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>>  findAll(){	//ResponseEntity -> class optimized for HTTP responses, encapsulates the necessary structure for this
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list); 		//ok() -> Instantiates ResponseEntity with HTTP success code. //body.() Set the body of the response entity and returns it.
	}
}
