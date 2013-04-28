package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Heating;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HeatingDAOImpl implements HeatingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Heating> listHeating() {
		return sessionFactory.getCurrentSession()
				.createQuery("select h from Heating h").list();
	}

	public Heating getHeating(long id) {
		return (Heating) sessionFactory.getCurrentSession()
				.createQuery("select h from Heating h where id = ?").setLong(0, id)
				.uniqueResult();
	}

}
