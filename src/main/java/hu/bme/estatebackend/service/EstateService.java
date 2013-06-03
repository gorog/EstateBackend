package hu.bme.estatebackend.service;

import hu.bme.estatebackend.model.City;
import hu.bme.estatebackend.model.Comment;
import hu.bme.estatebackend.model.Country;
import hu.bme.estatebackend.model.County;
import hu.bme.estatebackend.model.Favorites;
import hu.bme.estatebackend.model.Heating;
import hu.bme.estatebackend.model.Notification;
import hu.bme.estatebackend.model.NotificationType;
import hu.bme.estatebackend.model.Offer;
import hu.bme.estatebackend.model.Parking;
import hu.bme.estatebackend.model.Property;
import hu.bme.estatebackend.model.State;
import hu.bme.estatebackend.model.Type;
import hu.bme.estatebackend.model.User;
import hu.bme.wadl.Application;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface EstateService {
	public void addProperty(Property property);

	public List<Property> listProperty();

	public void removeProperty(Integer id);

	public String jsonListProperty();

	public Property getProperty(long id);

	public String getPropertyJson(long id);

	public String listPropertyJson(String county, String city, String heating,
			String offer, String parking, String state, String type,
			String user, String price, String rent, int elevator,
			String timestamp, int offset);

	public User getUser(String userName);

	public String getUserJson(String userName);

	public City getCity(long id);

	public String getCityJson(long id);

	public String listCityJson();

	public Country getCountry(long id);

	public String getCountryJson(long id);

	public String listCountryJson();

	public County getCounty(long id);

	public String getCountyJson(long id);

	public String listCountyJson();

	public Heating getHeating(long id);

	public String getHeatingJson(long id);

	public String listHeatingJson();

	public Notification getNotification(long id, String userName);

	public String listNotificationJson(String userName);

	public String getNotificationJson(long notificationId, String userName);

	public int setNotification(long id, String userName, boolean isread);

	public NotificationType getNotificationType(long id);

	public String getNotificationTypeJson(long id);

	public String listNotificationTypeJson();

	public Offer getOffer(long id);

	public String getOfferJson(long id);

	public String listOfferJson();

	public Parking getParking(long id);

	public String getParkingJson(long id);

	public String listParkingJson();

	public State getState(long id);

	public String getStateJson(long id);

	public String listStateJson();

	public Type getType(long id);

	public String getTypeJson(long id);

	public String listTypeJson();

	public void addComment(Comment comment);

	public Comment getComment(long id);

	public String getCommentJson(long id);

	public String listCommentJson(long propertyId);

	public String getPicture(long id);

	public String listPictureJson(long propertyId);

	public void addFavorites(Favorites favorites);

	public void removeFavorites(Integer id, String userName);

	public String getFavoritesJson(long id, String userName);

	public String listFavoritesJson(String userName);

	public Application generateWadl(HttpServletRequest request);
}
