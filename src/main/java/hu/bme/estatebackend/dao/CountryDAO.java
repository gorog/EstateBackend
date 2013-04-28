package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Country;

import java.util.List;

public interface CountryDAO {

	public List<Country> listCountry();

	public Country getCountry(long propertyId);
}
