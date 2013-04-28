package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Parking;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingDAOImpl implements ParkingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Parking> listParking() {
		return sessionFactory.getCurrentSession()
				.createQuery("select p from Parking p").list();
	}

	public Parking getParking(long id) {
		return (Parking) sessionFactory.getCurrentSession()
				.createQuery("select p from Parking p where id = ?")
				.setLong(0, id).uniqueResult();
	}

}
