package com.neosoft.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neosoft.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	@Query("from Student s where s.project.projectId=?1")
	List<Student> findStudentByProjectId(int projectId);

}
