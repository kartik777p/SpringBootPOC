package com.neosoft.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.Model.Student;
import com.neosoft.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudentById(int studentId) {
		
		return studentRepository.findById(studentId);
	}

	@Override
	public List<Student> getStudentByProjectId(int projectId) {
		
		return studentRepository.findStudentByProjectId(projectId);
	}

	@Override
	public void deleteStudentById(int studentId) {
	
		studentRepository.deleteById(studentId);
		
	}

}
