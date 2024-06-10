package com.grouplh.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.grouplh.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{ //MongoRepository<> provides all the necessary methods which help to create a CRUD application and it also supports the custom derived query methods
	
	

}
