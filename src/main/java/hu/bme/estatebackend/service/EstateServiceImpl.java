package hu.bme.estatebackend.service;

import hu.bme.estatebackend.dao.CityDAO;
import hu.bme.estatebackend.dao.CommentDAO;
import hu.bme.estatebackend.dao.CountryDAO;
import hu.bme.estatebackend.dao.CountyDAO;
import hu.bme.estatebackend.dao.HeatingDAO;
import hu.bme.estatebackend.dao.NotificationDAO;
import hu.bme.estatebackend.dao.NotificationTypeDAO;
import hu.bme.estatebackend.dao.OfferDAO;
import hu.bme.estatebackend.dao.ParkingDAO;
import hu.bme.estatebackend.dao.PropertyDAO;
import hu.bme.estatebackend.dao.StateDAO;
import hu.bme.estatebackend.dao.TypeDAO;
import hu.bme.estatebackend.dao.UserDAO;
import hu.bme.estatebackend.model.City;
import hu.bme.estatebackend.model.Comment;
import hu.bme.estatebackend.model.Country;
import hu.bme.estatebackend.model.County;
import hu.bme.estatebackend.model.Heating;
import hu.bme.estatebackend.model.Notification;
import hu.bme.estatebackend.model.NotificationType;
import hu.bme.estatebackend.model.Offer;
import hu.bme.estatebackend.model.Parking;
import hu.bme.estatebackend.model.Property;
import hu.bme.estatebackend.model.State;
import hu.bme.estatebackend.model.Type;
import hu.bme.estatebackend.model.User;
import hu.bme.gson.MyExclusionStrategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class EstateServiceImpl implements EstateService {

	@Autowired
	private PropertyDAO propertyDAO;
	@Autowired
	private CityDAO cityDAO;
	@Autowired
	private CountryDAO countryDAO;
	@Autowired
	private CountyDAO countyDAO;
	@Autowired
	private HeatingDAO heatingDAO;
	@Autowired
	private NotificationDAO notificationDAO;
	@Autowired
	private NotificationTypeDAO notificationTypeDAO;
	@Autowired
	private OfferDAO offerDAO;
	@Autowired
	private ParkingDAO parkingDAO;
	@Autowired
	private StateDAO stateDAO;
	@Autowired
	private TypeDAO typeDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CommentDAO commentDAO;

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
	public String getPropertyJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(propertyDAO.getProperty(id));
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
		if (list.size() > 0) {
			returnvalue = returnvalue.substring(0, returnvalue.length() - 2);
		}
		returnvalue = returnvalue.concat("]");
		return returnvalue;
	}

	@Transactional
	public String getCityJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(cityDAO.getCity(id));
		return json;
	}

	@Transactional
	public String listCityJson() {
		List<City> list = cityDAO.listCity();
		String returnvalue = "[";
		for (City p : list) {
			returnvalue = returnvalue.concat(p.toString() + ", ");
		}
		returnvalue = returnvalue.substring(0, returnvalue.length() - 2);
		returnvalue = returnvalue.concat("]");
		return returnvalue;
	}

	@Transactional
	public String getCountryJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(countryDAO.getCountry(id));
		return json;
	}

	@Transactional
	public String listCountryJson() {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(countryDAO.listCountry());
		return json;
	}

	@Transactional
	public String getCountyJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(countyDAO.getCounty(id));
		return json;
	}

	@Transactional
	public String listCountyJson() {
		List<County> list = countyDAO.listCounty();
		String returnvalue = "[";
		for (County p : list) {
			returnvalue = returnvalue.concat(p.toString() + ", ");
		}
		returnvalue = returnvalue.substring(0, returnvalue.length() - 2);
		returnvalue = returnvalue.concat("]");
		return returnvalue;
	}

	@Transactional
	public String getHeatingJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(heatingDAO.getHeating(id));
		return json;
	}

	@Transactional
	public String listHeatingJson() {
		Gson gson = new GsonBuilder().serializeNulls().create();

		String json = gson.toJson(heatingDAO.listHeating());
		return json;
	}

	@Transactional
	public String listNotificationJson(String userName) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(notificationDAO.listNotification(userName));
		return json;
	}

	@Transactional
	public String getNotificationJson(long notificationId, String userName) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(notificationDAO.getNotification(
				notificationId, userName));
		return json;
	}

	@Transactional
	public String getNotificationTypeJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(notificationTypeDAO.getNotificationType(id));
		return json;
	}

	@Transactional
	public String listNotificationTypeJson() {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(notificationTypeDAO.listNotificationType());
		return json;
	}

	@Transactional
	public String getOfferJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(offerDAO.getOffer(id));
		return json;
	}

	@Transactional
	public String listOfferJson() {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(offerDAO.listOffer());
		return json;
	}

	@Transactional
	public String getParkingJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(parkingDAO.getParking(id));
		return json;
	}

	@Transactional
	public String listParkingJson() {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(parkingDAO.listParking());
		return json;
	}

	@Transactional
	public String getStateJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(stateDAO.getState(id));
		return json;
	}

	@Transactional
	public String listStateJson() {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(stateDAO.listState());
		return json;
	}

	@Transactional
	public String getTypeJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(typeDAO.getType(id));
		return json;
	}

	@Transactional
	public String listTypeJson() {
		Gson gson = new GsonBuilder().serializeNulls().create();

		String json = gson.toJson(typeDAO.listType());
		return json;
	}

	@Transactional
	public Property getProperty(long id) {
		return propertyDAO.getProperty(id);
	}

	@Transactional
	public User getUser(String userName) {
		return userDAO.getUser(userName);
	}

	@Transactional
	public City getCity(long id) {
		return cityDAO.getCity(id);
	}

	@Transactional
	public Country getCountry(long id) {
		return countryDAO.getCountry(id);
	}

	@Transactional
	public County getCounty(long id) {
		return countyDAO.getCounty(id);
	}

	@Transactional
	public Heating getHeating(long id) {
		return heatingDAO.getHeating(id);
	}

	@Transactional
	public Notification getNotification(long id, String userName) {
		return notificationDAO.getNotification(id, userName);
	}

	@Transactional
	public NotificationType getNotificationType(long id) {
		return notificationTypeDAO.getNotificationType(id);
	}

	@Transactional
	public Offer getOffer(long id) {
		return offerDAO.getOffer(id);
	}

	@Transactional
	public Parking getParking(long id) {
		return parkingDAO.getParking(id);
	}

	@Transactional
	public State getState(long id) {
		return stateDAO.getState(id);
	}

	@Transactional
	public Type getType(long id) {
		return typeDAO.getType(id);
	}

	@Transactional
	public Comment getComment(long id) {
		return commentDAO.getComment(id);
	}

	@Transactional
	public String getCommentJson(long id) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		String json = gson.toJson(commentDAO.getComment(id));
		return json;
	}

	@Transactional
	public String listCommentJson(long propertyId) {
		List<Comment> list = commentDAO.listComment(propertyId);
		String returnvalue = "[";
		for (Comment p : list) {
			returnvalue = returnvalue.concat(p.toString() + ", ");
		}
		if (list.size() > 0) {
			returnvalue = returnvalue.substring(0, returnvalue.length() - 2);
		}
		returnvalue = returnvalue.concat("]");
		return returnvalue;
	}

	@Transactional
	public void addComment(Comment comment) {
		commentDAO.addComment(comment);
	}

}
