package hu.bme.estatebackend.property.service;

import hu.bme.estatebackend.property.form.Property;

import java.util.List;

public interface PropertyService {
	public void addProperty(Property contact);
    public List<Property> listProperty();
    public void removeProperty(Integer id);
    public String jsonListProperty();
}
