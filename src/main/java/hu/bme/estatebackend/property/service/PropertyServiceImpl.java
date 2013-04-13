package hu.bme.estatebackend.property.service;

import hu.bme.estatebackend.property.dao.PropertyDAO;
import hu.bme.estatebackend.property.form.Property;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyDAO propertyDAO;

	@Transactional
	public void addProperty(Property property) {
		propertyDAO.addProperty(property);
	}

	@Transactional
	public List<Property> listProperty() {
		return propertyDAO.listProperty();
	}

	@Transactional
	public void removeProperty(Integer id) {
		propertyDAO.removeProperty(id);
	}

	@Transactional
	public String jsonListProperty() {
		Gson gson = new Gson();

		String json = gson.toJson(propertyDAO.listProperty());
		return json;
	}

	@Transactional
	public String getPropertyJson(long propertyId) {
		Gson gson = new Gson();

		String json = gson.toJson(propertyDAO.getProperty(propertyId));
		return json;
	}
}
