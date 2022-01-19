package com.nit.Service;

import java.util.List;
import java.util.Optional;

import com.nit.Model.Project;

public interface ProjectService {
	
	public Project addProject(Project project);
	
	public List<Project> getAllProjects();
	
	public Optional<Project> findProjectById(int projectId);
	
	public void deleteProjectById(int projectId);

}
