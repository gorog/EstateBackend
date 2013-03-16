package hu.bme.estatebackend.property.dao;

import hu.bme.estatebackend.property.form.Property;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyDAOImpl implements PropertyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProperty(Property property) {
		sessionFactory.getCurrentSession().save(property);
	}

	public List<Property> listProperty() {
		return sessionFactory.getCurrentSession().createQuery("from Property")
				.list();
	}

	public void removeProperty(Integer id) {
		Property property = (Property) sessionFactory.getCurrentSession().load(
				Property.class, id);
		if (null != property) {
			sessionFactory.getCurrentSession().delete(property);
		}

	}

}
