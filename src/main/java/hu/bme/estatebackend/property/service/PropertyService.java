package hu.bme.estatebackend.property.service;

import hu.bme.estatebackend.property.form.Property;

import java.util.List;

public interface PropertyService {
	public void addProperty(Property contact);

	public List<Property> listProperty();

	public void removeProperty(Integer id);

	public String jsonListProperty();

	public String getPropertyJson(long propertyId);
	
	public String listPropertyJson(String county, String city, String heating, String offer, String parking, String state, String type, String user, String price, String rent, int elevator, String timestamp);
}
