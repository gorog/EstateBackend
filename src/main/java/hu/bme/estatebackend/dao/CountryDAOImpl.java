package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Country;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDAOImpl implements CountryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Country> listCountry() {
		return sessionFactory.getCurrentSession()
				.createQuery("select c from Country c").list();
	}

	public Country getCountry(long id) {
		return (Country) sessionFactory.getCurrentSession()
				.createQuery("select c from Country c where id = ?").setLong(0, id)
				.uniqueResult();
	}

}
