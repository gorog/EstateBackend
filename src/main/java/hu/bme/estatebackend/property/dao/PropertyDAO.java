package hu.bme.estatebackend.property.dao;

import hu.bme.estatebackend.property.form.Property;

import java.util.List;

public interface PropertyDAO {
    public void addProperty(Property property);
    public List<Property> listProperty();
    public void removeProperty(Integer id);
}
