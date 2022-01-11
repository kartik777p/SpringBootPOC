package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.entity.User;
import com.nit.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public List<User> getAllUsers() {
		//use repository class here
		return repo.findAll();
	}

	/*
	 @Override
	  public User getUserById(Integer id) {
	   Optional<User> opt=repo.findById(id); 
	   if(opt.isPresent()) return opt.get(); 
	   else
	    throw new IllegalArgumentException("There is no User found :- "+id+" for the given id... ");
	     }
	 */

	@Override
	public User getUserById(Integer id) {
		//Optional<User> opt=repo.findById(id);
		return repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No User Found for  the Given User id :- " + id));   //java 8
	}

	@Override
	public User saveUser(User user) {
		User us = null;
		//user with no id
		System.out.println("before saving user data is :- " + user.toString());
		us = repo.save(user); //internally uses parsist metod of jpa to save the new data
		System.out.println("After saving user data is :- " + user.toString());
		return us;
	}

	@Override
	public String updateUser(Integer id, User user) {
		User user1, us = null;
		//1st check there is user or not for the gievn id
		Optional<User> opt = repo.findById(id);
		if (opt.isPresent()) {
			user1 = opt.get();
		//gather values from saved obj and and store
			user1.setFirstName(user.getFirstName());
			user1.setLastName(user.getLastName());
			user1.setAddrs(user.getAddrs());
			user1.setDoj(user.getDoj());
			user1.setPinCode(user.getPinCode());
			//save changes to database
			us = repo.save(user1);  
			//us=repo.save(user);
			return "User Updated Sucessfully.....Updated User Details is :- " + us.toString();
		} else
			return "There is No User found for the given id :- " + user.getUId();
	}

	//Version 1- here we are giving msg to user if user does not exist 
/*	@Override
	public String deleteUserById(Integer id) {
		//Version 1- here we are giving msg to user if user does not exist 
		Optional<User> opt = repo.findById(id);
		if (opt.isPresent()) {
			User user = null;
			//get that object
			user = opt.get();
			//delete it from the database
			repo.delete(user);
			return "User deleted Sucessfully.........";
		}
		return "No User found For the given Id:- " + id + " to delete ";
	}   */

	//Version 2- here we are giving Exception to user if user does not exist 
	@Override
	public String deleteUserById(Integer id) {
		//check movie is there or not for given id...if have get movie obj ...if not there ..we wil get exception
		User user = repo.findById(id).orElseThrow(
				() -> new IllegalArgumentException("There is no User Found for the Given id :- " + id + " to delete"));
		//if user is there then delete it 
		repo.deleteById(id);
		return id + " :- id based Record is deleted Sucessfully.................";
	}     

	//Version 3- here is something diffrent..here if user does not exist we are not giving any msg or Exception..instread of that i am giving empty Entity class obj
	@Override
	public String deleteUserByObject(User user) {
		System.out.println("UserServiceImpl.deleteUserByObject()");
		//check record is there or not by using uid if there go further otherwise throw Exception
		User user1 = repo.findById(user.getUId()).orElse(new User());        //Will get exception some time --->The given id must not be null!
		//if user is there then delete it 
		repo.deleteById(user1.getUId());
		return user.getUId() + " :- id based Record is deleted Sucessfully.................";
	}

	@Override
	public String deleteUserSoftBit(Integer id) {
		Optional<User> opt=repo.findById(id);
		
		if(opt.isPresent()) {
			opt.get().setDeleted(1);
			repo.save(opt.get());	
			return "Record is deleted sucessfully....(Soft delete)";
		}
		return "Record is not deleted .Bcz there is no Record availble for the given id"+id+"...(Soft delete)";
	}
	@Override
	public String deleteAllUser() {
		//get count of records
		Long count=repo.count();
		//delete records
		//repo.deleteAll(); //here for each row one delete query is there
		repo.deleteAllInBatch();   //for the all record only one delete query (good)
		return count+" :-No of record is Deleted Sucessfully........";
	}
	@Override
	public Iterable<User> SortDetails(Boolean order, String... props) {
		//create sort obj bcz Sorting method want sort objs as param
		  Sort sort=Sort.by(order?Direction.ASC :Direction.DESC, props); //ternarry if order is true-->ASC   False--->Desc
		return repo.findAll(sort);
	}
	@Override
	public List<User> findByNameAndPinCode(String firstName,String lastName,Long pinCode) {
		return repo.findByFirstNameOrLastNameOrPinCode(firstName,lastName,pinCode);
	}

	@Override
	public List<User> getAllActiveUsers() {
		
		return repo.getAllActiveUsers();
	}    
}
