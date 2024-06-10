package com.grouplh.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grouplh.workshopmongo.domain.User;
import com.grouplh.workshopmongo.dto.UserDTO;
import com.grouplh.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired 											//Spring Boot dependency injection mechanism. Automatically instantiates the object
	private UserService service;
	
	
	@GetMapping 										//@RequestMapping(method=RequestMethod.GET) <<- works like that too
	public ResponseEntity<List<UserDTO>> findAll(){		//ResponseEntity -> class optimized for HTTP responses, encapsulates the necessary structure for this
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto); 		//Instantiates ResponseEntity with HTTP success code |> ok() Create a builder with the status set to OK. //body.() Set the body of the response entity and returns it.
	}
}
