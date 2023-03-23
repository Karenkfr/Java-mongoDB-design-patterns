package com.DesignPatterns.JavaMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.DesignPatterns.JavaMongo.domain.Post;
import com.DesignPatterns.JavaMongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	
}
