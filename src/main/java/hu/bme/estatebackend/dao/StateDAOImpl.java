package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.State;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StateDAOImpl implements StateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<State> listState() {
		return sessionFactory.getCurrentSession()
				.createQuery("select s from State s").list();
	}

	public State getState(long id) {
		return (State) sessionFactory.getCurrentSession()
				.createQuery("select s from State s where id = ?")
				.setLong(0, id).uniqueResult();
	}

}
