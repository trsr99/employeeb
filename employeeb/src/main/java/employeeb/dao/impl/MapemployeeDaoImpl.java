package employeeb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import employeeb.dao.MapemployeeDao;
import employeeb.model.Mapemployee;

@Repository
@Transactional
public class MapemployeeDaoImpl implements MapemployeeDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	public void add(Mapemployee mapemployee) {
		sessionFactory.getCurrentSession().save(mapemployee);

	}

	public void update(Mapemployee mapemployee) {
		sessionFactory.getCurrentSession().update(mapemployee);

	}

	public void delete(int rid) {
		sessionFactory.getCurrentSession().delete(getMapemployee(rid));

	}

	public Mapemployee getMapemployee(int rid) {
		return (Mapemployee)sessionFactory.getCurrentSession().get(Mapemployee.class,rid);
	}

	@SuppressWarnings("rawtypes")
	public List getAllMapemployee() {
		return sessionFactory.getCurrentSession().createQuery("from Mapemployee").list();
	}

}
