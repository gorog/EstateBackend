package hu.bme.estatebackend.property.dao;

import hu.bme.estatebackend.property.form.Property;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyDAOImpl implements PropertyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProperty(Property property) {
		sessionFactory.getCurrentSession().save(property);
	}

	public List<Property> listProperty() {
		return sessionFactory.getCurrentSession().createQuery("from Property")
				.list();
	}

	public void removeProperty(Integer id) {
		Property property = (Property) sessionFactory.getCurrentSession().load(
				Property.class, id);
		if (null != property) {
			sessionFactory.getCurrentSession().delete(property);
		}

	}

	public Property getProperty(long propertyId) {
		return (Property) sessionFactory.getCurrentSession()
				.createQuery("from Property where id = ?")
				.setString(0, String.valueOf(propertyId)).uniqueResult();
	}

	public List<Property> listProperty(String county, String city,
			String heating, String offer, String parking, String state,
			String type, String user, String price, String rent, int elevator,
			String timestamp, int offset) {

		String delimiter = ",";
		//String selectQuery = "select p from Property p, County cn, City c, Heating h, Offer o, Parking pa, State s, Type t, User u where (p.county = cn OR p.county is null) AND (p.city = c OR p.city is null) AND p.heating = h AND p.offer = o AND p.parking = pa AND p.state = s AND p.type = t AND p.user = u AND elevator IN (:elevators)";
		//(p.county = cn OR p.county is null) AND (p.city = c OR p.city is null) AND p.heating = h AND p.offer = o AND p.parking = pa AND p.state = s AND p.type = t AND p.user = u AND
		String selectQuery = "select p from Property p LEFT JOIN p.county cn LEFT JOIN p.city c LEFT JOIN p.heating h LEFT JOIN p.offer o LEFT JOIN p.parking pa LEFT JOIN p.state s LEFT JOIN p.type t LEFT JOIN p.user u where  elevator IN (:elevators)";
		List<String> countys = new ArrayList<String>();
		List<String> cities = new ArrayList<String>();
		List<String> heatings = new ArrayList<String>();
		List<String> offers = new ArrayList<String>();
		List<String> parkings = new ArrayList<String>();
		List<String> states = new ArrayList<String>();
		List<String> types = new ArrayList<String>();
		float minPrice = 0;
		float maxPrice = 999999999;
		float minRent = 0;
		float maxRent = 999999999;

		List<Integer> elevators = new ArrayList<Integer>();

		countys = Arrays.asList(county.split(delimiter));
		if (!countys.get(0).isEmpty()) {
			selectQuery += " AND cn.name IN (:countys)";
		}
		cities = Arrays.asList(city.split(delimiter));
		if (!cities.get(0).isEmpty()) {
			selectQuery += " AND c.name IN (:cities)";
		}
		heatings = Arrays.asList(heating.split(delimiter));
		if (!heatings.get(0).isEmpty()) {
			selectQuery += " AND h.name IN (:heatings)";
		}
		offers = Arrays.asList(offer.split(delimiter));
		if (!offers.get(0).isEmpty()) {
			selectQuery += " AND o.type IN (:offers)";
		}
		parkings = Arrays.asList(parking.split(delimiter));
		if (!parkings.get(0).isEmpty()) {
			selectQuery += " AND pa.name IN (:parkings)";
		}
		states = Arrays.asList(state.split(delimiter));
		if (!states.get(0).isEmpty()) {
			selectQuery += " AND s.name IN (:states)";
		}
		types = Arrays.asList(type.split(delimiter));
		if (!types.get(0).isEmpty()) {
			selectQuery += " AND t.name IN (:types)";
		}
		if (!user.isEmpty()) {
			selectQuery += " AND u.username IN (:user)";
		}

		if (!price.isEmpty()) {
			if (price.matches("min: [\\d]* max: [\\d]*")) {
				String temp[] = price.split(" ");
				minPrice = Float.valueOf(temp[1]);
				maxPrice = Float.valueOf(temp[3]);
			} else if (price.matches("min: [\\d]*")) {
				String temp[] = price.split(" ");
				minPrice = Float.valueOf(temp[1]);
			} else if (price.matches("max: [\\d]*")) {
				String temp[] = price.split(" ");
				maxPrice = Float.valueOf(temp[1]);
			}
			selectQuery += " AND price >= (:minPrice) AND price <= (:maxPrice)";
		}

		if (!rent.isEmpty()) {
			if (rent.matches("min: [\\d]* max: [\\d]*")) {
				String temp[] = rent.split(" ");
				minRent = Float.valueOf(temp[1]);
				maxRent = Float.valueOf(temp[3]);
			} else if (rent.matches("min: [\\d]*")) {
				String temp[] = price.split(" ");
				minRent = Float.valueOf(temp[1]);
			} else if (rent.matches("max: [\\d]*")) {
				String temp[] = price.split(" ");
				maxRent = Float.valueOf(temp[1]);
			}
			selectQuery += " AND price >= (:minRent) AND price <= (:maxRent)";
		}
		if (!timestamp.isEmpty()) {
			selectQuery += " AND timestamp >= :timestamp";
		}

		if (elevator == 1 || elevator == 0) {
			elevators.add(elevator);
		} else {
			elevators.add(0);
			elevators.add(1);
		}

		selectQuery += "ORDER BY p.timestamp DESC";
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery(selectQuery)
				.setParameterList("elevators", elevators);

		if (!countys.get(0).isEmpty()) {
			query = query.setParameterList("countys", countys);
		}
		if (!cities.get(0).isEmpty()) {
			query = query.setParameterList("cities", cities);
		}
		if (!heatings.get(0).isEmpty()) {
			query = query.setParameterList("heatings", heatings);
		}
		if (!offers.get(0).isEmpty()) {
			query = query.setParameterList("offers", offers);
		}
		if (!parkings.get(0).isEmpty()) {
			query = query.setParameterList("parkings", parkings);
		}
		if (!states.get(0).isEmpty()) {
			query = query.setParameterList("states", states);
		}
		if (!types.get(0).isEmpty()) {
			query = query.setParameterList("types", types);
		}
		if (!user.isEmpty()) {
			query = query.setString("user", user);
		}
		if (!price.isEmpty()) {
			query = query.setFloat("minPrice", minPrice).setFloat("maxPrice",
					maxPrice);
		}
		if (!rent.isEmpty()) {
			query = query.setFloat("minRent", minRent).setFloat("maxRent",
					maxRent);
		}
		if (!timestamp.isEmpty()) {
			try {
				query = query.setDate("timestamp", new SimpleDateFormat(
						"yyyy-MM-dd", Locale.FRANCE).parse(timestamp));
			} catch (ParseException e) {
			}
		}

		List<Property> result = (List<Property>) query.setFirstResult(offset).setMaxResults(12).list();
		System.out.println(result.get(5));

		return result;
	}
}
