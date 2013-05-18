package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Notification;

import java.util.List;

import org.hibernate.SessionFactory;
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
						"select n from Notification n Left Join n.user u where u.username = ?")
				.setString(0, userName).list();
	}

	public void removeNotification(Integer id) {
		Notification notification = (Notification) sessionFactory
				.getCurrentSession().load(Notification.class, id);
		if (null != notification) {
			sessionFactory.getCurrentSession().delete(notification);
		}

	}

	public Notification getNotification(long notificationId, String userName) {
		return (Notification) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select n from Notification n Left Join n.user u where u.username = ? and n.id = ?")
				.setString(0, userName).setLong(1, notificationId)
				.uniqueResult();
	}

	public int setNotification(long notificationId, String userName,
			boolean isread) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"update Notification n set n.isread = :isread where n.id = :id and n.user in ( select u from User u where u.username = :userName)")
				.setBoolean("isread", isread).setString("userName", userName)
				.setLong("id", notificationId).executeUpdate();
	}
}
