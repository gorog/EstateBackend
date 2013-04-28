package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Heating;

import java.util.List;

public interface HeatingDAO {
	public List<Heating> listHeating();

	public Heating getHeating(long id);
}
