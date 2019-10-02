package com.example.demo.ui.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ui.model.response.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping
	public String getUsers(@RequestParam(value="page", defaultValue="1") int page, @RequestParam(value="limit", defaultValue="1") int limit ){
		return "Page: " + page + "\nLimit: " + limit;
	}
	
	@GetMapping(path= "/{userId}")
	public ResponseEntity<UserRest> getUser(@PathVariable String userId){
		UserRest user = new UserRest();
		
		user.setEmail("rguezjosemanuel@gmail.com");
		user.setName("Josema");
		user.setId(userId);
		
		return new ResponseEntity<UserRest>(user, HttpStatus.OK);
	}
	
	@PostMapping ( consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	},
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userData) {
		UserRest user = new UserRest();
		
		user.setEmail(userData.getEmail());
		user.setName(userData.getName());
		user.setId(userData.getId());
		
		return new ResponseEntity<UserRest>(user, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
	
}
