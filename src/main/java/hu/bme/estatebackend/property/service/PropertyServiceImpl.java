package hu.bme.estatebackend.property.service;

import hu.bme.estatebackend.property.dao.PropertyDAO;
import hu.bme.estatebackend.property.form.Property;
import hu.bme.gson.MyExclusionStrategy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(propertyDAO.listProperty());
		return json;
	}

	@Transactional
	public String getPropertyJson(long propertyId) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(propertyDAO.getProperty(propertyId));
		return json;
	}

	@Transactional
	public String listPropertyJson(String county, String city, String heating,
			String offer, String parking, String state, String type,
			String user, String price, String rent, int elevator,
			String timestamp, int offset) {

		List<Property> list = propertyDAO.listProperty(county, city, heating,
				offer, parking, state, type, user, price, rent, elevator,
				timestamp, offset);
		String returnvalue = "[";
		for (Property p : list) {
			returnvalue = returnvalue.concat(p.toString() + ", ");
		}
		returnvalue = returnvalue.substring(0, returnvalue.length() - 2);
		returnvalue = returnvalue.concat("]");
		return returnvalue;
	}
}
