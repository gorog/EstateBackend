package hu.bme.estatebackend.property.controller;

import hu.bme.estatebackend.property.form.Property;
import hu.bme.estatebackend.property.form.User;
import hu.bme.estatebackend.property.service.NotificationService;
import hu.bme.estatebackend.property.service.PropertyService;
import hu.bme.estatebackend.property.service.UserService;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PropertyController {
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private UserService userService;
	@Autowired
	private NotificationService notificationService;

	@RequestMapping("/index")
	public String listPropertys(Map<String, Object> map) {

		map.put("property", new Property());
		map.put("propertyList", propertyService.listProperty());

		return "property";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProperty(@ModelAttribute("property") Property property,
			BindingResult result) {

		propertyService.addProperty(property);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{propertyId}")
	public String deleteProperty(@PathVariable("propertyId") Integer propertyId) {

		propertyService.removeProperty(propertyId);

		return "redirect:/index";
	}

	@RequestMapping("/full_list_api")
	public String jsonPropertys(Map<String, Object> map) {

		map.put("property", new Property());
		map.put("propertyList", propertyService.jsonListProperty());

		return "json";
	}

	@RequestMapping("/users")
	public String jsonUsers(Map<String, Object> map) {

		map.put("user", new User());
		map.put("data", userService.jsonListUser());

		return "json";
	}

	// Final
	@RequestMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-x8", value = "/v1/properties.json")
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
			Map<String, Object> map) {

		map.put("data", propertyService.listPropertyJson(county, city, heating,
				offer, parking, state, type, user, price, rent, elevator,
				timestamp));

		return "json";
	}

	@RequestMapping("/v1/properties/{propertyId}.json")
	public String getProperty(@PathVariable long propertyId,
			Map<String, Object> map) {

		map.put("data", propertyService.getPropertyJson(propertyId));

		return "json";
	}

	@RequestMapping("/v1/notifications.json")
	public String listNotification(Map<String, Object> map, Principal principal) {
		map.put("data",
				notificationService.jsonListNotification(principal.getName()));

		return "json";
	}

	@RequestMapping("/v1/notifications/{notificationId}.json")
	public String getNotification(@PathVariable long notificationId,
			Map<String, Object> map, Principal principal) {

		map.put("data", notificationService.getNotificationJson(notificationId));

		return "json";
	}
}
