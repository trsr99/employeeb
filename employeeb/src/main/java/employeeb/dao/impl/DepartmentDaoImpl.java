package employeeb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import employeeb.dao.DepartmentDao;
import employeeb.model.Department;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    private SessionFactory sessionFactory;
    
	public void add(Department department) {
		sessionFactory.getCurrentSession().save(department);

	}

	public void update(Department department) {
		sessionFactory.getCurrentSession().update(department);

	}

	public void delete(int rid) {
		sessionFactory.getCurrentSession().delete(getDepartment(rid));

	}

	public Department getDepartment(int rid) {
		return (Department)sessionFactory.getCurrentSession().get(Department.class,rid);
	}

	@SuppressWarnings("rawtypes")
	public List getAllDepartment() {
		return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}

}
