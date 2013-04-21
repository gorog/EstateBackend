package hu.bme.estatebackend.property.dao;

import hu.bme.estatebackend.property.form.Property;

import java.util.List;

public interface PropertyDAO {
	public void addProperty(Property property);

	public List<Property> listProperty();

	public void removeProperty(Integer id);

	public Property getProperty(long propertyId);

	public List<Property> listProperty(String county, String city, String heating,
			String offer, String parking, String state, String type,
			String user, String price, String rent, int elevator,
			String timestamp, int offset);
}
