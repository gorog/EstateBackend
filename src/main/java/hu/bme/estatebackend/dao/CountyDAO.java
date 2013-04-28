package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.County;

import java.util.List;

public interface CountyDAO {
	public List<County> listCounty();

	public County getCounty(long id);
}
