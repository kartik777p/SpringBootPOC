package com.nit.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.nit.entity.User;

public interface UserService {
   //get all users
	public List<User> getAllUsers();
	//get user by id
	public User getUserById(Integer id);
	//save user
	public User saveUser(User user);
	//update user(partial update
	public String updateUser(Integer id, User user);
	//delete user by user id
	public String deleteUserById(Integer id);
	//delete User by object
	public String deleteUserByObject(User user);
	//soft bit
	public String deleteUserSoftBit(Integer id);
	//delete all user
	public String deleteAllUser();
	//sort by dob or doj
	public Iterable<User> SortDetails(Boolean order,String... props);  //in one method we can use only one var args and that to last args of the method
  //find by name sername and pinCode
	public List<User> findByNameAndPinCode(String firstName,String lastName,Long pinCode);
	//
	public List<User> getAllActiveUsers();
}
