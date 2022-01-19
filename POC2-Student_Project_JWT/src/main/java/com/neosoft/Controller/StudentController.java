package com.neosoft.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.Model.Student;
import com.neosoft.Service.StudentService;


@RestController
//@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		
		return studentService.addStudent(student);
	}
	
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student,@PathVariable("studentId")int studentId) {
		Optional<Student>check=studentService.getStudentById(studentId);
		if(check.isPresent()) {
			student.setStudentId(studentId);
			studentService.addStudent(student);
		}
		return student;
	}

	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	
	@GetMapping("/getStudentById/{studentId}")
	public Optional<Student> getStudentById(@PathVariable("studentId")int studentId) {
		return studentService.getStudentById(studentId);
	}
	
	
	@GetMapping("/getStudentByProjectId/{projectId}")
	public List<Student> getStudentByProjectId(@PathVariable("projectId")int projectId) {
		return studentService.getStudentByProjectId(projectId);
	}
	
	
	@DeleteMapping("/deleteStudentById/{studentId}")
	public void deleteStudentById(@PathVariable("studentId")int studentId) {
		 studentService.deleteStudentById(studentId);
	}
}
