package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.State;

import java.util.List;

public interface StateDAO {
	public List<State> listState();

	public State getState(long id);
}
