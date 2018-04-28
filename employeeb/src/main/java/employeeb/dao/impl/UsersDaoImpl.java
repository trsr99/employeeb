package employeeb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import employeeb.dao.UsersDao;
import employeeb.model.Users;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	public void add(Users users) {
		sessionFactory.getCurrentSession().save(users);

	}

	public void update(Users users) {
		sessionFactory.getCurrentSession().update(users);

	}

	public void delete(String rid) {
		sessionFactory.getCurrentSession().delete(getUsers(rid));

	}

	public Users getUsers(String rid) {
		return (Users)sessionFactory.getCurrentSession().get(Users.class,rid);
	}

	@SuppressWarnings("rawtypes")
	public List getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

}
