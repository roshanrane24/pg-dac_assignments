package dao;

import pojos.Course;
import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchNewCourse(Course c) {
		String mesg = "Course launching failed!!!!!!!";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(c);
			tx.commit();
			mesg = "Launched new course with ID=" + c.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelCourse(int courseId) {
		String mesg = "Course cancellation failed!!!!!!!";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get course from it's id
			Course c = session.get(Course.class, courseId);
			if (c != null) {
				// delete the course
				session.delete(c);// c : REMOVED
				mesg = "Cancelled course with ID=" + courseId;
			}
			tx.commit();// auto dirty chking : delete : child recs first n then parent rec.

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Course getCourseDetails(String title) {
		Course c = null;
		String jpql = "select c from Course c where c.title = :title";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, Course.class).setParameter("title", title).getSingleResult();
			// c : PERSISTENT
			// lab exercise : c.getStudents().forEach(System.out::println); ---prints
			// details
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c;// c: DETACHED
	}

	@Override
	public Course getCourseStudentDetails(String title) {
		Course c = null;
		String jpql = "select c from Course c where c.title = :title";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, Course.class).setParameter("title", title).getSingleResult();// select :
																										// courses
			// c : PERSISTENT
			// simply access the size of collection , from within the session scope
			c.getStudents().size(); // select : students (confirm with adding brk points)
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c;// c: DETACHED
	}

	@Override
	public Course getCourseStudentDetailsJoinFetch(String title) {
		Course c=null;
	//	String jpql = "select c from Course c left outer join fetch c.students where c.title=:title";
		String jpql = "select c from Course c join fetch c.students where c.title=:title";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, Course.class).setParameter("title", title).getSingleResult();// select : 1 :
																										// inner join
																										// query to
																										// fetch data
																										// from courses n students
																										 

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c;
	}

}
