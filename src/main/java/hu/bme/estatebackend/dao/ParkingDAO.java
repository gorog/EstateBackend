package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Parking;

import java.util.List;

public interface ParkingDAO {
	public List<Parking> listParking();

	public Parking getParking(long id);
}
