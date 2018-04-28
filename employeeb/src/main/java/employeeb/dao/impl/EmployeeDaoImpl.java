package employeeb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import employeeb.dao.EmployeeDao;
import employeeb.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	public void add(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);

	}

	public void update(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);

	}

	public void delete(int rid) {
		sessionFactory.getCurrentSession().delete(getEmployee(rid));

	}

	public Employee getEmployee(int rid) {
		return (Employee)sessionFactory.getCurrentSession().get(Employee.class,rid);
	}

	@SuppressWarnings("rawtypes")
	public List getAllEmployee() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

}
