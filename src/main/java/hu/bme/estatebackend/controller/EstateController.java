package hu.bme.estatebackend.controller;

import hu.bme.estatebackend.model.Comment;
import hu.bme.estatebackend.model.Favorites;
import hu.bme.estatebackend.model.Property;
import hu.bme.estatebackend.service.EstateService;
import hu.bme.wadl.Application;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EstateController {
	@Autowired
	private EstateService estateService;
	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = "/v1/properties.json", method = RequestMethod.GET)
	public String listProperty(
			@RequestParam(value = "county", required = false, defaultValue = "") String county,
			@RequestParam(value = "city", required = false, defaultValue = "") String city,
			@RequestParam(value = "heating", required = false, defaultValue = "") String heating,
			@RequestParam(value = "offer", required = false, defaultValue = "") String offer,
			@RequestParam(value = "parking", required = false, defaultValue = "") String parking,
			@RequestParam(value = "state", required = false, defaultValue = "") String state,
			@RequestParam(value = "type", required = false, defaultValue = "") String type,
			@RequestParam(value = "user", required = false, defaultValue = "") String user,
			@RequestParam(value = "price", required = false, defaultValue = "") String price,
			@RequestParam(value = "rent", required = false, defaultValue = "") String rent,
			@RequestParam(value = "elevator", required = false, defaultValue = "3") int elevator,
			@RequestParam(value = "timestamp", required = false, defaultValue = "") String timestamp,
			@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
			Map<String, Object> map) {

		map.put("data", estateService.listPropertyJson(county, city, heating,
				offer, parking, state, type, user, price, rent, elevator,
				timestamp, offset));

		return "json";
	}

	@RequestMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-8", value = "/v1/properties/{id}.json", method = RequestMethod.POST)
	public String updateProperty(
			@PathVariable("id") long id,
			@RequestParam(value = "county", required = true, defaultValue = "0") int county,
			@RequestParam(value = "city", required = false, defaultValue = "0") int city,
			@RequestParam(value = "street", required = false, defaultValue = "") String street,
			@RequestParam(value = "house_number", required = false, defaultValue = "") String house_number,
			@RequestParam(value = "floor", required = false, defaultValue = "") String floor,
			@RequestParam(value = "room", required = false, defaultValue = "") String room,
			@RequestParam(value = "heating", required = false, defaultValue = "0") int heating,
			@RequestParam(value = "offer", required = true, defaultValue = "1") int offer,
			@RequestParam(value = "parking", required = false, defaultValue = "0") int parking,
			@RequestParam(value = "place", required = false, defaultValue = "") Float place,
			@RequestParam(value = "state", required = false, defaultValue = "0") int state,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "price", required = false, defaultValue = "") Float price,
			@RequestParam(value = "rent", required = false, defaultValue = "") Float rent,
			@RequestParam(value = "rooms", required = false, defaultValue = "") String rooms,
			@RequestParam(value = "longitude", required = false, defaultValue = "0") int longitude,
			@RequestParam(value = "latitude", required = false, defaultValue = "0") int latitude,
			@RequestParam(value = "elevator", required = false, defaultValue = "false") boolean elevator,
			@RequestParam(value = "comment", required = false, defaultValue = "") String comment,
			Map<String, Object> map, Principal principal) {

		String response = "";
		Property property = estateService.getProperty(id);
		if (property != null
				&& property.getUser().getUsername().equals(principal.getName())) {
			property.setCountry(estateService.getCounty(county).getCountry());
			property.setCounty(estateService.getCounty(county));
			property.setCity(estateService.getCity(city));
			property.setStreet(street);
			property.setHouse_number(house_number);
			property.setFloor(floor);
			property.setRoom(rooms);
			property.setHeating(estateService.getHeating(heating));
			property.setOffer(estateService.getOffer(offer));
			property.setParking(estateService.getParking(parking));
			property.setPlace(place);
			property.setState(estateService.getState(state));
			property.setType(estateService.getType(type));
			property.setRooms(rooms);
			property.setLongitude(longitude);
			property.setLatitude(latitude);
			property.setElevator(elevator);
			property.setComment(comment);

			estateService.addProperty(property);
			response = "\"ok\"";
		} else {
			response = "\"No property found for this user with the given id\"";
		}

		map.put("data", response);

		return "json";
	}

	@RequestMapping(value = "/v1/properties/{id}.json", method = RequestMethod.GET)
	public String getProperty(@PathVariable("id") long id,
			Map<String, Object> map) {

		map.put("data", estateService.getPropertyJson(id));

		return "json";
	}

	@RequestMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-8", value = "/v1/properties.json", method = RequestMethod.POST)
	public String addProperty(
			@RequestParam(value = "county", required = true, defaultValue = "0") int county,
			@RequestParam(value = "city", required = false, defaultValue = "0") int city,
			@RequestParam(value = "street", required = false, defaultValue = "") String street,
			@RequestParam(value = "house_number", required = false, defaultValue = "") String house_number,
			@RequestParam(value = "floor", required = false, defaultValue = "") String floor,
			@RequestParam(value = "room", required = false, defaultValue = "") String room,
			@RequestParam(value = "heating", required = false, defaultValue = "0") int heating,
			@RequestParam(value = "offer", required = true, defaultValue = "1") int offer,
			@RequestParam(value = "parking", required = false, defaultValue = "0") int parking,
			@RequestParam(value = "place", required = false, defaultValue = "") Float place,
			@RequestParam(value = "state", required = false, defaultValue = "0") int state,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "price", required = false, defaultValue = "") Float price,
			@RequestParam(value = "rent", required = false, defaultValue = "") Float rent,
			@RequestParam(value = "rooms", required = false, defaultValue = "") String rooms,
			@RequestParam(value = "longitude", required = false, defaultValue = "0") int longitude,
			@RequestParam(value = "latitude", required = false, defaultValue = "0") int latitude,
			@RequestParam(value = "elevator", required = false, defaultValue = "false") boolean elevator,
			@RequestParam(value = "comment", required = false, defaultValue = "") String comment,
			Map<String, Object> map, Principal principal) {

		String response = "";
		Property property = new Property();
		System.out.println(county + " " + city + " "
				+ estateService.getCity(city).getCounty().getId());
		if (county == estateService.getCity(city).getCounty().getId()) {

			property.setCountry(estateService.getCounty(county).getCountry());
			property.setCounty(estateService.getCounty(county));
			property.setCity(estateService.getCity(city));
			property.setStreet(street);
			property.setHouse_number(house_number);
			property.setFloor(floor);
			property.setRoom(rooms);
			property.setHeating(estateService.getHeating(heating));
			property.setOffer(estateService.getOffer(offer));
			property.setParking(estateService.getParking(parking));
			property.setPlace(place);
			property.setState(estateService.getState(state));
			property.setType(estateService.getType(type));
			property.setRooms(rooms);
			property.setLongitude(longitude);
			property.setLatitude(latitude);
			property.setElevator(elevator);
			property.setComment(comment);
			property.setUser(estateService.getUser(principal.getName()));
			java.util.Date date = new java.util.Date();
			property.setTimestamp(new Timestamp(date.getTime()));

			response = String.valueOf(estateService.addProperty(property));

		} else {
			response = "\"error\"";
		}

		map.put("data", response);

		return "plaintext";
	}

	@RequestMapping(value = "/v1/notifications.json", method = RequestMethod.GET)
	public String listNotification(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listNotificationJson(principal.getName()));

		return "json";
	}

	@RequestMapping(value = "/v1/notifications/{id}.json", method = RequestMethod.GET)
	public String getNotification(@PathVariable("id") long id,
			Map<String, Object> map, Principal principal) {

		map.put("data",
				estateService.getNotificationJson(id, principal.getName()));

		return "json";
	}

	@RequestMapping(value = "/v1/notifications/{id}.json", method = RequestMethod.POST)
	public String setNotification(
			@PathVariable("id") long id,
			Map<String, Object> map,
			@RequestParam(value = "isread", required = true, defaultValue = "true") boolean isread,
			Principal principal) {

		int updated = estateService.setNotification(id, principal.getName(),
				isread);
		if (updated > 0) {
			map.put("data", "\"ok\"");
		} else {
			map.put("data", "\"no_changes\"");
		}

		return "json";
	}

	@RequestMapping(value = "/v1/cities.json", method = RequestMethod.GET)
	public String listCity(Map<String, Object> map) {
		map.put("data", estateService.listCityJson());

		return "json";
	}

	@RequestMapping(value = "/v1/cities/{id}.json", method = RequestMethod.GET)
	public String getCity(@PathVariable("id") long id, Map<String, Object> map) {

		map.put("data", estateService.getCityJson(id));

		return "json";
	}

	@RequestMapping(value = "/v1/countries.json", method = RequestMethod.GET)
	public String listCountries(Map<String, Object> map) {
		map.put("data", estateService.listCountryJson());

		return "json";
	}

	@RequestMapping(value = "/v1/countries/{id}.json", method = RequestMethod.GET)
	public String getCountries(@PathVariable("id") long id,
			Map<String, Object> map, Principal principal) {

		map.put("data", estateService.getCountryJson(id));

		return "json";
	}

	@RequestMapping(value = "/v1/counties.json", method = RequestMethod.GET)
	public String listCounties(Map<String, Object> map) {
		map.put("data", estateService.listCountyJson());

		return "json";
	}

	@RequestMapping(value = "/v1/counties/{id}.json", method = RequestMethod.GET)
	public String getCounties(@PathVariable("id") long id,
			Map<String, Object> map) {

		map.put("data", estateService.getCountyJson(id));

		return "json";
	}

	@RequestMapping(value = "/v1/heatings.json", method = RequestMethod.GET)
	public String listHeatings(Map<String, Object> map) {
		map.put("data", estateService.listHeatingJson());

		return "json";
	}

	@RequestMapping(value = "/v1/heatings/{id}.json", method = RequestMethod.GET)
	public String getHeating(@PathVariable("id") long id,
			Map<String, Object> map) {

		map.put("data", estateService.getHeatingJson(id));

		return "json";
	}

	@RequestMapping(value = "/v1/notificationtypes.json", method = RequestMethod.GET)
	public String listNotificationTypes(Map<String, Object> map) {
		map.put("data", estateService.listNotificationTypeJson());

		return "json";
	}

	@RequestMapping(value = "/v1/notificationtypes/{id}.json", method = RequestMethod.GET)
	public String getNotificationType(@PathVariable("id") long id,
			Map<String, Object> map) {

		map.put("data", estateService.getNotificationTypeJson(id));

		return "json";
	}

	@RequestMapping(value = "/v1/offers.json", method = RequestMethod.GET)
	public String listOffers(Map<String, Object> map) {
		map.put("data", estateService.listOfferJson());

		return "json";
	}

	@RequestMapping(value = "/v1/offers/{id}.json", method = RequestMethod.GET)
	public String getOffer(@PathVariable("id") long id, Map<String, Object> map) {

		map.put("data", estateService.getOfferJson(id));

		return "json";
	}

	@RequestMapping(value = "/v1/parkings.json", method = RequestMethod.GET)
	public String listParkings(Map<String, Object> map) {
		map.put("data", estateService.listParkingJson());

		return "json";
	}

	@RequestMapping(value = "/v1/parking/{id}.json", method = RequestMethod.GET)
	public String getParking(@PathVariable("id") long id,
			Map<String, Object> map) {

		map.put("data", estateService.getParkingJson(id));

		return "json";
	}

	@RequestMapping(value = "/v1/states.json", method = RequestMethod.GET)
	public String listStates(Map<String, Object> map) {
		map.put("data", estateService.listStateJson());

		return "json";
	}

	@RequestMapping(value = "/v1/states/{id}.json", method = RequestMethod.GET)
	public String getState(@PathVariable("id") long id, Map<String, Object> map) {

		map.put("data", estateService.getStateJson(id));

		return "json";
	}

	@RequestMapping(value = "/v1/types.json", method = RequestMethod.GET)
	public String listTypes(Map<String, Object> map) {
		map.put("data", estateService.listTypeJson());

		return "json";
	}

	@RequestMapping(value = "/v1/types/{id}.json", method = RequestMethod.GET)
	public String getType(@PathVariable("id") long id, Map<String, Object> map) {

		map.put("data", estateService.getTypeJson(id));

		return "json";
	}

	@RequestMapping(value = "/v1/comments.json", method = RequestMethod.GET)
	public String listComments(
			Map<String, Object> map,
			@RequestParam(value = "property", required = true, defaultValue = "0") long property,
			Principal principal) {

		map.put("data", estateService.listCommentJson(property));

		return "json";
	}

	@RequestMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-8", value = "/v1/comments.json", method = RequestMethod.POST)
	public String addComment(
			Map<String, Object> map,
			@RequestParam(value = "property", required = true, defaultValue = "0") long property,
			@RequestParam(value = "comment", required = true, defaultValue = "0") String comment,
			@RequestParam(value = "commentid", required = false, defaultValue = "0") long commentid,
			Principal principal) {

		String response = "";
		Comment mComment = new Comment();

		mComment.setComment(comment);
		mComment.setUser(estateService.getUser(principal.getName()));
		mComment.setProperty(estateService.getProperty(property));
		mComment.setCommentId(estateService.getComment(commentid));
		java.util.Date date = new java.util.Date();
		mComment.setTimestamp(new Timestamp(date.getTime()));

		estateService.addComment(mComment);

		map.put("data", response);
		return "json";
	}

	@RequestMapping(value = "/v1/comments/{id}.json", method = RequestMethod.GET)
	public String getComment(@PathVariable("id") long id,
			Map<String, Object> map, Principal principal) {

		map.put("data", estateService.getCommentJson(id));

		return "json";
	}

	@RequestMapping(value = "/v1/pictures/{propertyid}", method = RequestMethod.GET)
	public String listPictureUrls(@PathVariable("propertyid") long propertyid,
			Map<String, Object> map) {

		map.put("data", estateService.listPictureJson(propertyid));

		return "json";
	}

	@RequestMapping(value = "/v1/favorites.json", method = RequestMethod.GET)
	public String listFavorites(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listFavoritesJson(principal.getName()));

		return "json";
	}

	@RequestMapping(value = "/v1/favorites/{id}.json", method = RequestMethod.GET)
	public String getFavorite(@PathVariable("id") long id,
			Map<String, Object> map, Principal principal) {

		map.put("data", estateService.getFavoritesJson(id, principal.getName()));

		return "json";
	}

	@RequestMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-8", value = "/v1/favorites.json", method = RequestMethod.POST)
	public String addFavorite(
			Map<String, Object> map,
			@RequestParam(value = "property", required = true, defaultValue = "0") long property,
			Principal principal) {

		String response = "";
		Favorites mFavorites = new Favorites();

		mFavorites.setProperty(estateService.getProperty(property));
		mFavorites.setUser(estateService.getUser(principal.getName()));

		estateService.addFavorites(mFavorites);

		map.put("data", response);
		return "json";
	}

	@RequestMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-8", value = "/v1/favorites/{id}.json", method = RequestMethod.POST)
	public String deleteFavorite(Map<String, Object> map,
			@PathVariable("id") int id, Principal principal) {

		String response = "";

		estateService.removeFavorites(id, principal.getName());

		map.put("data", response);
		return "json";
	}

	@RequestMapping(value = "/v1/users/{userName}.json", method = RequestMethod.GET)
	public String getUser(@PathVariable("userName") String userName,
			Map<String, Object> map) {

		map.put("data", estateService.getUserJson(userName));

		return "json";
	}

	@RequestMapping(value = "/v1/application.wadl", method = RequestMethod.GET, produces = { "application/xml" })
	public @ResponseBody
	Application generateWadl(HttpServletRequest request) {
		Application result = new Application();
		result = estateService.generateWadl(request);

		return result;
	}
}
