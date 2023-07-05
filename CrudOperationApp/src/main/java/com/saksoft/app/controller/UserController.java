package com.saksoft.app.controller;

import java.util.List;

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

import com.saksoft.app.model.User;
import com.saksoft.app.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> saveUserDetails(@RequestBody User user){
		User user1=userService.addUser(user);
		return new ResponseEntity<User>(user1,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userService.fetchAllUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id){
		User user=userService.fetchUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> saveUserDetails(@RequestBody User user,@PathVariable int id){
		User user1=userService.updateUser(user,id);
		return new ResponseEntity<User>(user1,HttpStatus.CREATED);
		
	} 
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUserDetails(@PathVariable int id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("User Deleted Successfully",HttpStatus.NOT_FOUND);
	}

}
