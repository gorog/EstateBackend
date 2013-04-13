package hu.bme.estatebackend.property.controller;

import hu.bme.estatebackend.property.form.Property;
import hu.bme.estatebackend.property.form.User;
import hu.bme.estatebackend.property.service.PropertyService;
import hu.bme.estatebackend.property.service.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PropertyController {
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private UserService userService;

	/*
	 * @RequestMapping("/") public String home(Map<String, Object> map) { return
	 * "redirect:/index"; }
	 */

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String userDetails(Map<String, Object> map) {

		map.put("message", "Spring Security Hello World");

		return "userdetails";
	}

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
		map.put("propertyList", userService.jsonListUser());

		return "json";
	}

	// Final
	@RequestMapping("/v1/properties/{propertyId}")
	public String selectProperty(@PathVariable long propertyId,
			Map<String, Object> map) {

		map.put("data", propertyService.getPropertyJson(propertyId));

		return "json";
	}
}
