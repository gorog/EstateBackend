package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Type;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TypeDAOImpl implements TypeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Type> listType() {
		return sessionFactory.getCurrentSession()
				.createQuery("select t from Type t").list();
	}

	public Type getType(long id) {
		return (Type) sessionFactory.getCurrentSession()
				.createQuery("select t from Type t where id = ?").setLong(0, id)
				.uniqueResult();
	}

}
