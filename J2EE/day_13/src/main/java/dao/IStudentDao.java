package dao;

import java.util.List;

import pojos.Address;
import pojos.AdharCard;
import pojos.EducationQulification;
import pojos.Student;

public interface IStudentDao {
	// student admission
	String admitNewStudent(String courseName, Student student);

	// cancel specific student's admission from a specific course
	String cancelAdmission(String courseName, int studentId);
	
	// Add user details
	String addUserDetails(String email, AdharCard adharCard, List<String> hobbies, EducationQulification education, Address address);
}
