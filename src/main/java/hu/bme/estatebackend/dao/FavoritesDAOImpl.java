package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Favorites;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FavoritesDAOImpl implements FavoritesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addFavorites(Favorites favorites) {
		sessionFactory.getCurrentSession().save(favorites);
	}

	public List<Favorites> listFavorites(String userName) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"select f from Favorites f Left Join f.user u where u.username = ?")
				.setString(0, userName).list();
	}

	public void removeFavorites(Integer id, String userName) {
		Favorites favorites = (Favorites) sessionFactory.getCurrentSession()
				.load(Favorites.class, id);
		if (null != favorites) {
			if (favorites.getUser().getUsername().equals(userName)) {
				sessionFactory.getCurrentSession().delete(favorites);
			}
		}

	}

	public Favorites getFavorites(long id, String userName) {
		return (Favorites) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select f from Favorites f Left Join f.user u where u.username = ? and f.id = ?")
				.setString(0, userName).setLong(1, id).uniqueResult();

	}
}
