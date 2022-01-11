package com.nit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
 
	
	//Finder method 
	//get byNameAndPinCode
	List<User> findByFirstNameOrLastNameOrPinCode(String firstName, String lastName, Long pinCode);

	//to findByFirstName
	List<User> findByFirstName(String firstName);

	//to findByLatName
	List<User> findByLastName(String lastName);

	//to findByLatName
	List<User> findByPinCode(Long pinCode);

	//to findByAddrs
	List<User> findByAddrs(String addrs);

	//orderby DOb ASC
	List<User> findByOrderByDobAsc();

	//orderby DOb DESC
	List<User> findByOrderByDobDesc();

	//orderby DOb ASC
	List<User> findByOrderByDojAsc();

	//orderby DOb DESC
	List<User> findByOrderByDojDesc();
    
	@Query("From User u where u.deleted=0")
	List<User> getAllActiveUsers();

}
