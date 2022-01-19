package com.neosoft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.Model.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

}
