package com.lcwd.user.service.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.ServiceImpl.UserServiceImpl;
import com.lcwd.user.service.entities.Post;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.repository.PostRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userSer;
	
	@Autowired
	PostRepository postRepo;

	// save
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User user1 = userSer.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	// getAll
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUser = userSer.getAllUser();
		return ResponseEntity.ok(allUser);
	}

	// getById
	@GetMapping("/{userId}")
	public ResponseEntity<EntityModel<User>> getById(@PathVariable String userId) {
		User byId = userSer.getById(userId);
		EntityModel<User> entModUser = EntityModel.of(byId);
		WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getAllUsers());
		entModUser.add(linkBuilder.withRel("all-users"));
		return ResponseEntity.status(HttpStatus.OK).body(entModUser);
	}
	
	// getting all post for a particular user
	@GetMapping("getAllPost/{id}")
	public List<Post> getAllPostbyUserId(@PathVariable String id) {
		User byId = userSer.getById(id);
		return byId.getPosts();
	}
	
	// Creating a new post for a particular user
	@PostMapping("post/{id}")
	public void createPost(@PathVariable String id,@RequestBody Post post) {
		User byId = userSer.getById(id);
		post.setUser(byId);
		postRepo.save(post);
	}

}
