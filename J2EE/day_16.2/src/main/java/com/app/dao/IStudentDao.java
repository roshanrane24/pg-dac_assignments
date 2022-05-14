package com.app.dao;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.AdharCard;
import com.app.pojos.EducationQulification;
import com.app.pojos.Student;

public interface IStudentDao {
	
	// Get user Details
	Student getStudentDetail();
	
	// Add user details
	String addUserDetails(String email, AdharCard adharCard, List<String> hobbies, EducationQulification education, Address address);
}
