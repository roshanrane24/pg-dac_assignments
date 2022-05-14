package com.app.dao;

import java.util.List;

public interface IProjectDao {
	List<String> getProjects();
	
	List<Student> getStudentInProject()
}