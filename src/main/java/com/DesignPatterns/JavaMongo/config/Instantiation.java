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
import com.DesignPatterns.JavaMongo.dto.CommentDTO;
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
		postRepository.deleteAll();

		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2023"), "Começando o bootcamp", "Estou começando o bootcamp Java na Dio!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/03/2023"), "Java é legal!", "eu adoro programar em Java!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Estou começando também!", sdf.parse("21/03/2023"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Já programo em Java, vou fazer o bootcamp para aprofundar meus conhecimentos.", sdf.parse("21/03/2023"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Bacana! estou com dificuldades em Arrays.. poderia me ajudar?", sdf.parse("21/03/2023"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
	}

}
