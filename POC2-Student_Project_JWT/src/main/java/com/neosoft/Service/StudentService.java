package com.neosoft.Service;

import java.util.List;
import java.util.Optional;

import com.neosoft.Model.Student;

public interface StudentService {
	
	public Student addStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Optional<Student> getStudentById(int studentId);
	
	public List<Student> getStudentByProjectId(int projectId);
	
	public void deleteStudentById(int studentId);

}
