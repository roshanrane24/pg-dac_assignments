package com.app.dao;

import java.util.List;


//import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<String> getDepartments() {
		String jpql = "select distinct e.department from Employee e";
		return factory.getCurrentSession().createQuery(jpql, String.class).getResultList();
	}

	@Override
	public List<Employee> getEmployees(String dept) {
		String jpql = "select e from Employee e where e.department = :dept";
		return factory.getCurrentSession().createQuery(jpql, Employee.class).setParameter("dept",  dept).getResultList();
	}

}
