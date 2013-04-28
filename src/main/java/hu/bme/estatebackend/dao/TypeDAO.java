package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Type;

import java.util.List;

public interface TypeDAO {
	public List<Type> listType();

	public Type getType(long id);
}
