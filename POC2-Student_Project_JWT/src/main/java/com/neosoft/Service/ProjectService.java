package com.neosoft.Service;

import java.util.List;
import java.util.Optional;

import com.neosoft.Model.Project;

public interface ProjectService {
	
	public Project addProject(Project project);
	
	public List<Project> getAllProjects();
	
	public Optional<Project> findProjectById(int projectId);
	
	public void deleteProjectById(int projectId);

}
