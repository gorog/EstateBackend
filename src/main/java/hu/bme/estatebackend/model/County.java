package hu.bme.estatebackend.model;

import hu.bme.gson.MyExclusionStrategy.Serialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTY")
public class County {
	@Serialize
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Serialize
	@Column(name = "NAME")
	private String name;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	public County() {
		super();
	}

	public County(Integer id, String name, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String toString() {
		return ("{ \"id\":" + id + ", \"name\": \"" + name
				+ "\", \"country\": " + country.getId() + " }");
	}

}
