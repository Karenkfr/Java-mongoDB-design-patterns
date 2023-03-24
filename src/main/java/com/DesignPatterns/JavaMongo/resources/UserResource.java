package com.DesignPatterns.JavaMongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.DesignPatterns.JavaMongo.domain.Post;
import com.DesignPatterns.JavaMongo.domain.User;
import com.DesignPatterns.JavaMongo.dto.UserDTO;
import com.DesignPatterns.JavaMongo.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/users")
@Api("Api Usuários do microblog")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	@ApiOperation("Listar todos os usuários")
	@ApiResponse(code = 200, message = "Todos os usuários listados")
	public ResponseEntity<List<UserDTO>> findAll(){
	
		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation("Buscar usuário por Id")
	@ApiResponse(code = 200, message= "Usuário encontrado")
	@GetMapping("{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	
	@PostMapping
	@ApiOperation("Inserir um novo usuário")
	@ApiResponse(code = 201, message = "Usuário cadastrado com sucesso")
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
		User obj = userService.fromDTO(objDto);
		obj = userService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("{id}")
	@ApiOperation("Deletar um usuário")
	@ApiResponse(code = 201, message = "Usuário deletado com sucesso.")
	public ResponseEntity<Void> delete(@PathVariable String id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("{id}")
	@ApiOperation("Editar um usuário")
	@ApiResponse(code = 201, message = "Usuário editado com sucesso.")
		public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
		User obj = userService.fromDTO(objDto);
		obj.setId(id);
		obj = userService.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{id}/posts")
	@ApiOperation("Buscar posts pelo id do usuário")
	@ApiResponse(code = 200, message = "Posts localizados com sucesso.")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User obj = userService.findById(id);
		obj.getPosts();
		return ResponseEntity.ok().body(obj.getPosts());
	}
	
	
	
	
}
