package hu.bme.estatebackend.controller;

import hu.bme.estatebackend.model.Comment;
import hu.bme.estatebackend.model.Property;
import hu.bme.estatebackend.service.EstateService;
import hu.bme.estatebackend.service.PropertyService;
import hu.bme.estatebackend.service.UserService;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Szabo Tamas
 * 
 */
@Controller
public class EstateController {
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private EstateService estateService;
	@Autowired
	private UserService userService;

	/**
	 * @param county
	 * @param city
	 * @param street
	 * @param house_number
	 * @param floor
	 * @param room
	 * @param heating
	 * @param offer
	 * @param parking
	 * @param place
	 * @param state
	 * @param type
	 * @param price
	 * @param rent
	 * @param rooms
	 * @param longitude
	 * @param latitude
	 * @param elevator
	 * @param comment
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/v1/properties.json", method = RequestMethod.POST)
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
		// county és city.county eltér?
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

		estateService.addProperty(property);

		map.put("data", response);

		return "json";
	}

	/**
	 * @param county
	 * @param city
	 * @param heating
	 * @param offer
	 * @param parking
	 * @param state
	 * @param type
	 * @param user
	 * @param price
	 * @param rent
	 * @param elevator
	 * @param timestamp
	 * @param offset
	 * @param map
	 * @return
	 */
	@RequestMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-8", value = "/v1/properties.json")
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

	/**
	 * 
	 * 
	 * @param id
	 * @param county
	 * @param city
	 * @param street
	 * @param house_number
	 * @param floor
	 * @param room
	 * @param heating
	 * @param offer
	 * @param parking
	 * @param place
	 * @param state
	 * @param type
	 * @param price
	 * @param rent
	 * @param rooms
	 * @param longitude
	 * @param latitude
	 * @param elevator
	 * @param comment
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-x8", value = "/v1/properties/{id}.json", method = RequestMethod.POST)
	public String updateProperty(
			@PathVariable long id,
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

	/**
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/v1/properties/{id}.json")
	public String getProperty(@PathVariable long id, Map<String, Object> map) {

		map.put("data", estateService.getPropertyJson(id));

		return "json";
	}

	/**
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/notifications.json")
	public String listNotification(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listNotificationJson(principal.getName()));

		return "json";
	}

	/**
	 * @param id
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/notifications/{id}.json")
	public String getNotification(@PathVariable long id,
			Map<String, Object> map, Principal principal) {

		map.put("data",
				estateService.getNotificationJson(id, principal.getName()));

		return "json";
	}

	/**
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/cities.json")
	public String listCity(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listCityJson());

		return "json";
	}

	/**
	 * @param id
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/cities/{id}.json")
	public String getCity(@PathVariable long id, Map<String, Object> map,
			Principal principal) {

		map.put("data", estateService.getCityJson(id));

		return "json";
	}

	/**
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/countries.json")
	public String listCountries(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listCountryJson());

		return "json";
	}

	/**
	 * @param id
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/countries/{id}.json")
	public String getCountries(@PathVariable long id, Map<String, Object> map,
			Principal principal) {

		map.put("data", estateService.getCountryJson(id));

		return "json";
	}

	/**
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/counties.json")
	public String listCounties(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listCountyJson());

		return "json";
	}

	@RequestMapping("/v1/counties/{id}.json")
	public String getCounties(@PathVariable long id, Map<String, Object> map,
			Principal principal) {

		map.put("data", estateService.getCountyJson(id));

		return "json";
	}

	/**
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/heatings.json")
	public String listHeatings(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listHeatingJson());

		return "json";
	}

	/**
	 * @param id
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/heatings/{id}.json")
	public String getHeating(@PathVariable long id, Map<String, Object> map,
			Principal principal) {

		map.put("data", estateService.getHeatingJson(id));

		return "json";
	}

	/**
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/notificationtypes.json")
	public String listNotificationTypes(Map<String, Object> map,
			Principal principal) {
		map.put("data", estateService.listNotificationTypeJson());

		return "json";
	}

	/**
	 * @param id
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/notificationtypes/{id}.json")
	public String getNotificationType(@PathVariable long id,
			Map<String, Object> map, Principal principal) {

		map.put("data", estateService.getNotificationTypeJson(id));

		return "json";
	}

	/**
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/offers.json")
	public String listOffers(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listOfferJson());

		return "json";
	}

	/**
	 * @param id
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/offers/{id}.json")
	public String getOffer(@PathVariable long id, Map<String, Object> map,
			Principal principal) {

		map.put("data", estateService.getOfferJson(id));

		return "json";
	}

	/**
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/parkings.json")
	public String listParkings(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listParkingJson());

		return "json";
	}

	/**
	 * @param id
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/parking/{id}.json")
	public String getParking(@PathVariable long id, Map<String, Object> map,
			Principal principal) {

		map.put("data", estateService.getParkingJson(id));

		return "json";
	}

	/**
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/states.json")
	public String listStates(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listStateJson());

		return "json";
	}

	/**
	 * @param id
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/states/{id}.json")
	public String getState(@PathVariable long id, Map<String, Object> map,
			Principal principal) {

		map.put("data", estateService.getStateJson(id));

		return "json";
	}

	/**
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/types.json")
	public String listTypes(Map<String, Object> map, Principal principal) {
		map.put("data", estateService.listTypeJson());

		return "json";
	}

	/**
	 * @param id
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/types/{id}.json")
	public String getType(@PathVariable long id, Map<String, Object> map,
			Principal principal) {

		map.put("data", estateService.getTypeJson(id));

		return "json";
	}

	/**
	 * @param map
	 * @param property
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/comments.json")
	public String listComments(
			Map<String, Object> map,
			@RequestParam(value = "property", required = true, defaultValue = "0") long property,
			Principal principal) {

		map.put("data", estateService.listCommentJson(property));

		return "json";
	}

	/**
	 * @param map
	 * @param property
	 * @param comment
	 * @param comment_id
	 * @param principal
	 * @return
	 */
	@RequestMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-8", value = "/v1/comments.json", method = RequestMethod.POST)
	public String addComment(
			Map<String, Object> map,
			@RequestParam(value = "property", required = true, defaultValue = "0") long property,
			@RequestParam(value = "comment", required = true, defaultValue = "0") String comment,
			@RequestParam(value = "comment_id", required = false, defaultValue = "0") long comment_id,
			Principal principal) {

		String response = "";
		Comment mComment = new Comment();

		mComment.setComment(comment);
		mComment.setUser(estateService.getUser(principal.getName()));
		mComment.setProperty(estateService.getProperty(property));
		mComment.setCommentId(estateService.getComment(comment_id));
		java.util.Date date = new java.util.Date();
		mComment.setTimestamp(new Timestamp(date.getTime()));

		estateService.addComment(mComment);

		map.put("data", response);
		return "json";
	}

	/**
	 * @param id
	 * @param map
	 * @param principal
	 * @return
	 */
	@RequestMapping("/v1/comments/{id}.json")
	public String getComment(@PathVariable long id, Map<String, Object> map,
			Principal principal) {

		map.put("data", estateService.getCommentJson(id));

		return "json";
	}

}
