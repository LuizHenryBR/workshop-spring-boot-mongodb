package com.grouplh.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.grouplh.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ //MongoRepository<> provides all the necessary methods which help to create a CRUD application and it also supports the custom derived query methods
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") //https://www.mongodb.com/docs/manual/reference/operator/query/regex/
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text); //Spring Data Query Method, do auto generated consult. https://docs.spring.io/spring-data/mongodb/reference/mongodb/repositories/query-methods.html

	@Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, "
			+ "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
