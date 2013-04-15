package hu.bme.estatebackend.property.dao;

import hu.bme.estatebackend.property.form.Notification;
import hu.bme.estatebackend.property.form.User;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationDAOImpl implements NotificationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addNotification(Notification notification) {
		sessionFactory.getCurrentSession().save(notification);
	}

	public List<Notification> listNotification(String userName) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"select n from Notification n, User u where n.user = u AND u.username = ? ")
				.setString(0, userName).list();
	}

	public void removeNotification(Integer id) {
		Notification notification = (Notification) sessionFactory
				.getCurrentSession().load(Notification.class, id);
		if (null != notification) {
			sessionFactory.getCurrentSession().delete(notification);
		}

	}

	public Notification getNotification(long notificationId) {
		return (Notification) sessionFactory.getCurrentSession()
				.createQuery("from Notification where id = ")
				.setLong(0, notificationId).uniqueResult();
	}
}
