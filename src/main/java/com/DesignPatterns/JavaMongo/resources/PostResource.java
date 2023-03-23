package com.DesignPatterns.JavaMongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.DesignPatterns.JavaMongo.domain.Post;
import com.DesignPatterns.JavaMongo.domain.User;
import com.DesignPatterns.JavaMongo.dto.UserDTO;
import com.DesignPatterns.JavaMongo.services.PostService;
import com.DesignPatterns.JavaMongo.services.UserService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping("{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
