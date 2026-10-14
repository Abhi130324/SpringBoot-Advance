package in.sp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entities.User;
import in.sp.main.service.UserService;

@RestController
public class MyController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user) {// we need user entity for userdetails
		return userService.createUser(user);
	}

	@GetMapping("/user")
	public List<User> getAllUserDetails() {
		return userService.getAllUser();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDetails(@PathVariable int id) {// path variable helps to gt the id from post and for sending response we use response entity class
		User user = userService.getUserDetails(id).orElse(null);
		if(user != null) {
			return ResponseEntity.ok().body(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateuserDetails(@PathVariable int id,@RequestBody User user) {//we need to get id and object
		User updatedUser = userService.upateUserDetails(id, user);
		if(updatedUser != null) {
			ResponseEntity.ok(updatedUser);//you can write it above way
		}else {
			 ResponseEntity.notFound().build();
		}
		return null;
	}

	
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id){
	userService.deleteUser(id);
	return ResponseEntity.noContent().build();
}
}
	
	
