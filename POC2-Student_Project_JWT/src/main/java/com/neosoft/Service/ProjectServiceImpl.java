package com.neosoft.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.Model.Project;
import com.neosoft.Repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project addProject(Project project) {
		
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getAllProjects() {
	
		return projectRepository.findAll();
	}

	@Override
	public Optional<Project> findProjectById(int projectId) {
		
		return projectRepository.findById(projectId);
	}

	@Override
	public void deleteProjectById(int projectId) {

         projectRepository.deleteById(projectId);
		
	}

}
