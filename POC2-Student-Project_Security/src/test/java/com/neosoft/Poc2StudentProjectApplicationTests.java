package com.neosoft;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.nit.Model.Project;
import com.nit.Model.Student;
import com.nit.Repository.ProjectRepository;
import com.nit.Repository.StudentRepository;

@SpringBootTest
class Poc2StudentProjectApplicationTests {
	
	@Autowired 
	private ProjectRepository projectRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	void findProjectById() {
		Assert.notNull(projectRepository.findById(1));
	}
	
	@Test
	void addProject() {
	Project project=new Project(10,"Bank","6 month");
	Assert.notNull(projectRepository.save(project));
	}
	
	@Test
	void  updateProject() {
	Project project=new Project(10,"Bank","6 month");
	Assert.notNull(projectRepository.save(project));
	}
	
	@Test
	void deleteProjectById() {
	     projectRepository.deleteById(3);
		assertThat(projectRepository.existsById(3)).isFalse();
	}
	
	@Test
	void addStudent() {
		Project project =new Project(3,"MIS App ","6 months ");
	Student student=new Student(40,"Rohit","Kumar","9878987898","rohit@gmail.com",project);
	Assert.notNull(studentRepository.save(student));
	}
	
	@Test
	void updateStudent() {
		Project project =new Project(3,"MIS App ","5 months ");
	Student student=new Student(20,"Rohit","Kumar","9878987898","rohit@gmail.com",project);
	Assert.notNull(studentRepository.save(student));
	}
	
	@Test
	void findStudentById() {
		Assert.notNull(studentRepository.findById(16));
	}
	
	@Test
	void findStudentByProjectId() {
		Assert.notNull(studentRepository.findStudentByProjectId(4));
	}
	
	
	@Test
	void deleteStudentById() {
		studentRepository.deleteById(3);
		assertThat(studentRepository.existsById(3)).isFalse();
	}
	

}
