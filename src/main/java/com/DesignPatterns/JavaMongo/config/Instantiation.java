package com.DesignPatterns.JavaMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.DesignPatterns.JavaMongo.domain.Post;
import com.DesignPatterns.JavaMongo.domain.User;
import com.DesignPatterns.JavaMongo.dto.AuthorDTO;
import com.DesignPatterns.JavaMongo.repository.PostRepository;
import com.DesignPatterns.JavaMongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();

		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2023"), "Começando o bootcamp", "Estou começando o bootcamp Java na Dio!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/03/2023"), "Java é legal!", "minhas primeiras linhas com Java, estou amando!", new AuthorDTO(maria));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
