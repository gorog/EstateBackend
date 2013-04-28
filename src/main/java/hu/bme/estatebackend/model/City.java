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
@Table(name = "CITY")
public class City {
	@Serialize
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Serialize
	@Column(name = "NAME")
	private String name;

	@Serialize
	@Column(name = "ZIP_CODE")
	private String zipCode;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "COUNTY_ID")
	private County county;

	public City() {
		super();
	}

	public City(Integer id, String name, String zipCode, County county) {
		super();
		this.id = id;
		this.name = name;
		this.zipCode = zipCode;
		this.county = county;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public County getCounty() {
		return county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public String toString() {
		return ("{ \"id\":" + id + ", \"name\": \"" + name
				+ "\", \"zipCode\": \"" + zipCode + "\", \"county\": "
				+ county.getId() + " }");
	}
}
