package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.County;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountyDAOImpl implements CountyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<County> listCounty() {
		return sessionFactory.getCurrentSession()
				.createQuery("select c from County c").list();
	}

	public County getCounty(long id) {
		return (County) sessionFactory.getCurrentSession()
				.createQuery("select c from County c where id = ?")
				.setLong(0, id).uniqueResult();
	}

}
