package hu.bme.estatedroid.property;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTY")
public class Property {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name="COUNTRY")
    private String country;
	
	@Column(name="CITY")
    private String city;
	
	@Column(name="ZIP_CODE")
    private String zip_code;
	
	@Column(name="DISTRCT")
    private String district;
	
	@Column(name="STREET")
    private String street;
	
	@Column(name="HOUSE_NUMBER")
    private String house_number;
	
	@Column(name="FLOOR")
    private String floor;
	
	@Column(name="ROOM")
    private String room;
	
	@Column(name="LONGITUDE")
    private Integer longitude;
	
	@Column(name="LATITUDE")
    private Integer latitude;
	
	@Column(name="OFFER")
    private String offer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	
}
