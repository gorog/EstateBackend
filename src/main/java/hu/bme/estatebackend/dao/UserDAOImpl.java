package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.User;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public User getUser(String userName) {
		return (User) sessionFactory.getCurrentSession()
				.createQuery("select u from User u where username = ?")
				.setString(0, userName).uniqueResult();
	}

	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public List<User> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from User")
				.list();
	}

	public void removeUser(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class,
				id);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

}
