package com.nit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.nit.entity.User;
import com.nit.repository.UserRepository;

import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;


@SpringBootTest
class Poc01RestApplicationTests {

	@Autowired
	private UserRepository repo;
	@Test
	void testRecordById() {
		org.springframework.util.Assert.notNull(repo.getById(20));
	}
	
	@Test   //tocheck size 
	void testFindAll() {
		List<User> list=repo.findAll();
		assertThat(list).size().isGreaterThan(0);
		assertThat(list).isNotEmpty(); //to check list is empty or not
		
	}
	
	@Test
	public void testSingleUser() {
		User user=repo.findById(18).get();
		//use equals method to check its data
		assertEquals("Shital", user.getFirstName());
		assertEquals("Ghatole", user.getLastName());
		assertEquals(876543, user.getPinCode());
		assertEquals("Pune", user.getAddrs());
		assertEquals(0, user.getDeleted());
		
	}

	@Test
	public void testUpdate() {
	User user=	repo.findById(17).get();
	//change  addrs
	user.setAddrs("Alegaon");
	//check not nmatching condicction
    assertNotEquals("Mumbai", user.getAddrs());
	}
	
	@Test
	public void testSaveUser() {
		Date doj=new Date();
		//prepare dob
		Date dob=new Date();
		dob.setYear(7);
		dob.setMonth(10);
		dob.setDate(2);
		//prepare user obj having details
		User us=new User();
		us.setFirstName("shubh");
		us.setLastName("navghare");
		us.setDob(dob);
		us.setDoj(doj);
		us.setPinCode(345678L);
		us.setAddrs("gujrat");
		//save user to database
		User user=repo.save(us);
		Assert.notNull(user);
	}
	
	@Test
	public void testForFirstName() {
		Assert.notNull(repo.findByFirstName("Shital"));
	}
	
	@Test
	public void testForLastName() {
		Assert.notNull(repo.findByLastName("Ghatole"));
	}

	@Test
	public void testForPinCode() {
		Assert.notNull(repo.findByPinCode(444511L));
	}
	@Test
	public void testForAddrs() {
		Assert.notNull(repo.findByAddrs("Akola"));
	}
	@Test
	public void testForDobAsc() {
		Assert.notNull(repo.findByOrderByDobAsc());
	}
	@Test
	public void testForDobDesc() {
		Assert.notNull(repo.findByOrderByDobDesc());
	}
	@Test
	public void testForDojAsc() {
		Assert.notNull(repo.findByOrderByDojAsc());
	}
	@Test
	public void testForDojDesc() {
		Assert.notNull(repo.findByOrderByDojDesc());
	}
	
	@Test
	public void testForFirstNameLastNameAndPinCode() {
		Assert.notNull(repo.findByFirstNameOrLastNameOrPinCode("Kartik", "Pastapure", 444511L));
	}
	
	public void testDeleteUserByObjectOrId() {
		User us=repo.getById(56);
		//delete by object
		Assert.notNull(us);
	}
}
