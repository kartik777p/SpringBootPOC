package com.nit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.Model.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

}
