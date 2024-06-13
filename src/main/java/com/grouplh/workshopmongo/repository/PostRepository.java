package com.grouplh.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.grouplh.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ //MongoRepository<> provides all the necessary methods which help to create a CRUD application and it also supports the custom derived query methods
	
	List<Post> findByTitleContainingIgnoreCase(String text); //Spring Data Query Method, do auto generated consult. https://docs.spring.io/spring-data/mongodb/reference/mongodb/repositories/query-methods.html

}
