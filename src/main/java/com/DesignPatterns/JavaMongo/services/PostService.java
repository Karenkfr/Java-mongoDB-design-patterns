package com.DesignPatterns.JavaMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DesignPatterns.JavaMongo.domain.Post;
import com.DesignPatterns.JavaMongo.domain.User;
import com.DesignPatterns.JavaMongo.dto.UserDTO;
import com.DesignPatterns.JavaMongo.repository.PostRepository;
import com.DesignPatterns.JavaMongo.repository.UserRepository;
import com.DesignPatterns.JavaMongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	
}
