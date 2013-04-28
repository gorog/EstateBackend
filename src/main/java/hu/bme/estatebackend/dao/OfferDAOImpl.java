package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Offer;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OfferDAOImpl implements OfferDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Offer> listOffer() {
		return sessionFactory.getCurrentSession()
				.createQuery("select o from Offer o").list();
	}

	public Offer getOffer(long id) {
		return (Offer) sessionFactory.getCurrentSession()
				.createQuery("select o from Offer o where id = ?")
				.setLong(0, id).uniqueResult();
	}

}
