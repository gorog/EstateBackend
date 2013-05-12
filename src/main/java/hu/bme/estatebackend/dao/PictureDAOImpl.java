package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Picture;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PictureDAOImpl implements PictureDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addPicture(Picture picture) {
		sessionFactory.getCurrentSession().save(picture);
	}

	public List<Picture> listPicture(long property) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from Picture p Left Join p.property pr where pr.id = ?")
				.setLong(0, property).list();
	}

	public void removePicture(Integer id) {
		Picture picture = (Picture) sessionFactory.getCurrentSession().load(
				Picture.class, id);
		if (null != picture) {
			sessionFactory.getCurrentSession().delete(picture);
		}
	}

	public Picture getPicture(long picture) {
		return (Picture) sessionFactory.getCurrentSession()
				.createQuery("select p from Picture p")
				.uniqueResult();
	}

	public String getPictureUrl(long picture) {
		return ((Picture) sessionFactory.getCurrentSession()
				.createQuery("select p from Picture p")
				.uniqueResult()).getUrl();
	}

}
