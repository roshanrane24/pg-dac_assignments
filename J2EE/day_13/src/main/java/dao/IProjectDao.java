package dao;

import java.util.Set;

import pojos.Project;
import pojos.Student;

public interface IProjectDao {
	//launch new project
	String launchNewProject(Project project);
	
	//add student to a project
	String addStudentToProject(int projectId,int studentId);
	
	//remove student from a project
	String removeStudentFromProject(int projectId,int studentId);
	
	// Get student from project
	Set<Student> getStudentFromProject(String projectName);
	
	// Remove project
	String removeProject(int projectId);

}
