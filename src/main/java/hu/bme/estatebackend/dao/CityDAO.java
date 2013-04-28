package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.City;

import java.util.List;

public interface CityDAO {
	public List<City> listCity();

	public City getCity(long id);
}
