package dao;

import pojos.Course;

public interface ICourseDao {
//launch new course
	String launchNewCourse(Course c);

	// cancel the course
	String cancelCourse(int courseId);

	// get course details
	Course getCourseDetails(String title);

	// get course n student details : using a hint : size() : using multiple selects
	Course getCourseStudentDetails(String title);

	// get course n student details : using join fetch : using singl join query
	Course getCourseStudentDetailsJoinFetch(String title);
}
