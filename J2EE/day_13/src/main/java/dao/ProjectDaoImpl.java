package dao;

import static utils.HibernateUtils.getFactory;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Project;
import pojos.Student;

public class ProjectDaoImpl implements IProjectDao {

	@Override
	public String launchNewProject(Project project) {
		String mesg = "Failed to create new project";

		// Get Session from SF
		Session session = getFactory().getCurrentSession();

		// Begin transaction
		Transaction tx = session.beginTransaction();

		try {
			// Persist the project
			session.persist(project);

			// Commit Transaction
			tx.commit();

			mesg = "Added project " + project.getTitle() + " with id " + project.getId();
		} catch (RuntimeException e) {
			// Rollback transaction
			if (tx != null)
				tx.rollback();

			throw e;
		}

		return mesg;
	}

	@Override
	public String addStudentToProject(int projectId, int studentId) {
		String mesg = "Failed to add student with id " + studentId + " to project";

		// Get Session from SF
		Session session = getFactory().getCurrentSession();

		// Begin transaction
		Transaction tx = session.beginTransaction();

		try {
			// Get persistent objects
			Student s = session.get(Student.class, studentId);
			Project p = session.get(Project.class, projectId);

			if (s != null && p != null) {
				// Add student to project
				p.addStudent(s);
				mesg = "Added student " + s.getName() + " to project " + p.getTitle();
			}

			// Commit Transaction
			tx.commit();

		} catch (RuntimeException e) {
			// Rollback transaction
			if (tx != null)
				tx.rollback();

			throw e;
		}

		return mesg;
	}

	@Override
	public String removeStudentFromProject(int projectId, int studentId) {
		String mesg = "Failed to remove student with id " + studentId + " from project";

		// Get Session from SF
		Session session = getFactory().getCurrentSession();

		// Begin transaction
		Transaction tx = session.beginTransaction();

		try {
			// Get persistent objects
			Student s = session.get(Student.class, studentId);
			Project p = session.get(Project.class, projectId);

			if (s != null && p != null) {
				// Remove student to project
				p.removeStudent(s);
				mesg = "Added student " + s.getName() + " to project " + p.getTitle();
			}

			// Commit Transaction
			tx.commit();

		} catch (RuntimeException e) {
			// Rollback transaction
			if (tx != null)
				tx.rollback();

			throw e;
		}

		return mesg;
	}

	@Override
	public Set<Student> getStudentFromProject(String projectName) {
		Set<Student> students = new HashSet<>();

		// JPQL
		String jpql = "select p from Project p where p.title = :title";

		// Get Session from SF
		Session session = getFactory().getCurrentSession();

		// Begin transaction
		Transaction tx = session.beginTransaction();

		try {
			// Get persistent objects
			Project p = session.createQuery(jpql, Project.class).setParameter("title", projectName).getSingleResult();

			System.out.println("Found " + p.getStudents().size() + " in " + projectName + ".");

			students = p.getStudents();

			// Commit Transaction
			tx.commit();
		} catch (RuntimeException e) {
			// Rollback transaction
			if (tx != null)
				tx.rollback();

			throw e;
		}

		return students;
	}

	@Override
	public String removeProject(int projectId) {
		String mesg = "Failed to remove project";

		// Get Session from SF
		Session session = getFactory().getCurrentSession();

		// Begin transaction
		Transaction tx = session.beginTransaction();

		try {
			// Get persistent objects
			Project p = session.get(Project.class, projectId);

			if (p != null) {
				// Remove students from projects
//				p.getStudents().forEach(s -> p.removeStudent(s));
				// Try
//				p.getStudents().clear();

				// mark project for delete // no need to delete child
				session.delete(p);
			}

			// Commit Transaction
			tx.commit();
		} catch (RuntimeException e) {
			// Rollback transaction
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return mesg;
	}
}
