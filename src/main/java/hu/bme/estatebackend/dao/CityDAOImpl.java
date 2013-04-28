package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.City;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDAOImpl implements CityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<City> listCity() {
		return sessionFactory.getCurrentSession()
				.createQuery("select c from City c").list();
	}

	public City getCity(long id) {
		return (City) sessionFactory.getCurrentSession()
				.createQuery("select c from City c where id = ?").setLong(0, id)
				.uniqueResult();
	}

}
