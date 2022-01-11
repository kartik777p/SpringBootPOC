package com.nit.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.User;
import com.nit.service.UserService;

import lombok.Delegate;

@RestController
public class UserController {
	@Autowired
	private UserService service;
      
	//http://localhost:8080/users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		//return 
		return service.getAllUsers();
	}

	//get user by id       //http://localhost:8080/users/1
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		return service.getUserById(id);
	}

	//save user
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		//set current date
		user.setDoj(new Date());
       return service.saveUser(user);
	}
	//update
	@PutMapping("/users/{id}")
	public String updateUser(@PathVariable("id") Integer id,@RequestBody User user) {
		return service.updateUser(id, user);
	}
	
	//delete by id
/*	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		return service.deleteUserById(id);
	}   */
	
	//delete by object 
	@DeleteMapping("/users")
	public String deleteUser(@RequestBody User user) {
		return service.deleteUserByObject(user);
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUserSoftBit(@PathVariable("id") Integer id) {
		return service.deleteUserSoftBit(id);
	}
	
	//deleteAll the Record
	@DeleteMapping("/usersAll")
	public String deleteAllUser() {
		return service.deleteAllUser();
	}
	
	//sort user   BY doj and dob        //http://localhost:8080/users/true/dob/doj
	@GetMapping("/users/{flag}/{dob}/{doj}")
	public Iterable<User> SortUser(@PathVariable Boolean flag, @PathVariable String dob,@PathVariable String doj ){
		return service.SortDetails(flag, dob,doj);
	}
	
	//http://localhost:8080/usersFind/Kartik/Dalvi/675432
	@GetMapping("/usersFind/{firstName}/{lastName}/{pinCode}")
	public List<User> findByFirstNameLastNameOrPinCode(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName,@PathVariable("pinCode") Long pinCode){
		return service.findByNameAndPinCode(firstName,lastName,pinCode);
	}
	
@GetMapping("/usersActive")
	public List<User> getAllActiveUsers(){
		return service.getAllActiveUsers();
	}   

}