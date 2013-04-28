package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.NotificationType;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationTypeDAOImpl implements NotificationTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<NotificationType> listNotificationType() {
		return sessionFactory.getCurrentSession()
				.createQuery("select n from NotificationType n").list();
	}

	public NotificationType getNotificationType(long id) {
		return (NotificationType) sessionFactory.getCurrentSession()
				.createQuery("select n from NotificationType n where id = ?")
				.setLong(0, id).uniqueResult();
	}

}
