package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Student;

public class AddressDaoImpl implements IAddressDao {

	@Override
	public String assignAddressDetails(int studentId, Address a) {
		String mesg="linking address failed";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			//get student details by id
			Student s=session.get(Student.class, studentId);
			if(s != null)
			{
			//	System.out.println(a.getStudent());//null
				//not null
				a.setStudent(s);//established uni dir asso from Address ---> Student
				session.persist(a);
				mesg="linking address done for student "+s.getName();
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
