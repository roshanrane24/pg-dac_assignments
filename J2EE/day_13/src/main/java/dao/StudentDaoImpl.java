package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.AdharCard;
import pojos.Course;
import pojos.EducationQulification;
import pojos.Student;
import static utils.HibernateUtils.getFactory;

import java.util.List;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String admitNewStudent(String courseName, Student student) {
		String mesg = "student admission failed";
		String jpql = "select c from Course c where c.title=:title";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get Course from course name : JPQL
			Course c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
			// => course found , c: PERSISTENT
			// establish bi-dir link using helper method
			c.addStudent(student);
			// session.persist(student);//explicitly saving student details
			tx.commit();
			mesg = "student " + student.getName() + " admitted in course " + courseName;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelAdmission(String courseName, int studentId) {
		String mesg = "student's admission  cancellation failed";
		String jpql = "select c from Course c where c.title=:title";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get course from it's name
			Course c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
			// => course found , c: PERSISTENT
			Student s = session.get(Student.class, studentId);
			if (s != null) {
				// remove bi dir link : removeStudent
				c.removeStudent(s);
				mesg = "student " + s.getName() + " admission  cancelled";
			}

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String addUserDetails(String email, AdharCard adharCard, List<String> hobbies,
			EducationQulification education, Address address) {
		String mesg = "Failed to add student details";
		String jpql = "select s from Student s where s.email =: email";

		// get Session from SF
		Session session = getFactory().getCurrentSession();

		// begin tx
		Transaction tx = session.beginTransaction();

		try {
			// Get user
			Student student = session.createQuery(jpql, Student.class).setParameter("email", email).getSingleResult();
			
			student.setAdhar(adharCard);
			student.setHobbies(hobbies);
			student.addQualification(education);
			
			// persist address
			address.setStudent(student);
			session.persist(address);
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
