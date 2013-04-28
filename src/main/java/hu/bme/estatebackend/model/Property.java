package hu.bme.estatebackend.model;

import hu.bme.gson.MyExclusionStrategy.Serialize;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTY")
public class Property {

	@Serialize
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID", nullable = true)
	private Country country;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "COUNTY_ID", nullable = true)
	private County county;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "CITY_ID", nullable = true)
	private City city;

	@Serialize
	@Column(name = "STREET")
	private String street;

	@Serialize
	@Column(name = "HOUSE_NUMBER")
	private String house_number;

	@Serialize
	@Column(name = "FLOOR")
	private String floor;

	@Serialize
	@Column(name = "ROOM")
	private String room;

	@Serialize
	@Column(name = "LONGITUDE")
	private Integer longitude;

	@Serialize
	@Column(name = "LATITUDE")
	private Integer latitude;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "OFFER_ID")
	private Offer offer;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	private Type type;

	@Serialize
	@Column(name = "PRICE")
	private Float price;

	@Serialize
	@Column(name = "RENT")
	private Float rent;

	@Serialize
	@Column(name = "PLACE")
	private Float place;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "STATE_ID")
	private State state;

	@Serialize
	@Column(name = "ROOMS_NUMBER")
	private String rooms;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "HEATING_ID")
	private Heating heating;

	@Serialize
	@Column(name = "ELEVATOR")
	private boolean elevator;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "PARKING_ID")
	private Parking parking;

	@Serialize
	@Column(name = "COMMENT")
	private String comment;

	@Serialize
	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;

	public Property() {
		super();
	}

	public Property(Integer id, User user, Country country, County county,
			City city, String street, String house_number, String floor,
			String room, Integer longitude, Integer latitude, Offer offer,
			Type type, Float price, Float rent, Float place, State state,
			String rooms, Heating heating, boolean elevator, Parking parking,
			String comment, Timestamp timestamp) {
		super();
		this.id = id;
		this.user = user;
		this.country = country;
		this.county = county;
		this.city = city;
		this.street = street;
		this.house_number = house_number;
		this.floor = floor;
		this.room = room;
		this.longitude = longitude;
		this.latitude = latitude;
		this.offer = offer;
		this.type = type;
		this.price = price;
		this.rent = rent;
		this.place = place;
		this.state = state;
		this.rooms = rooms;
		this.heating = heating;
		this.elevator = elevator;
		this.parking = parking;
		this.comment = comment;
		this.timestamp = timestamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public County getCounty() {
		return county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getRent() {
		return rent;
	}

	public void setRent(Float rent) {
		this.rent = rent;
	}

	public Float getPlace() {
		return place;
	}

	public void setPlace(Float place) {
		this.place = place;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public Heating getHeating() {
		return heating;
	}

	public void setHeating(Heating heating) {
		this.heating = heating;
	}

	public boolean isElevator() {
		return elevator;
	}

	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String toString() {
		String countyName = "null";
		String cityName = "null";
		if (county != null) {
			countyName = county.getName();
		}
		if (city != null) {
			cityName = city.getName();
		}
		return ("{ \"id\":" + id + ", \"user\": \"" + user.getUsername()
				+ "\", \"country\": \"" + country.getName()
				+ "\", \"county\": \"" + countyName + "\", \"city\": \""
				+ cityName + "\", \"street\": \"" + street
				+ "\", \"house_number\": \"" + house_number
				+ "\", \"floor\": \"" + floor + "\", \"room\": \"" + room
				+ "\", \"longitude\": " + longitude + ", \"latitude\": "
				+ latitude + ", \"offer\": \"" + offer.getType()
				+ "\", \"type\": \"" + type.getName() + "\", \"price\": "
				+ price + ", \"rent\": " + rent + ", \"place\": " + place
				+ ", \"state\": \"" + state.getName() + "\", \"rooms\": \""
				+ rooms + "\", \"heating\": \"" + heating.getName()
				+ "\", \"elevator\": " + elevator + ", \"parking\": \""
				+ parking.getName() + "\", \"comment\": \"" + comment
				+ "\", \"timestamp\": \"" + timestamp + "\" }");
	}

}
