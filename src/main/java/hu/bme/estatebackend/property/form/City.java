package hu.bme.estatebackend.property.form;

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
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	@ManyToOne
	@JoinColumn(name = "COUNTY_ID")
	private Country county;

	public City(Integer id, String name, String zipCode, Country county) {
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

	public Country getCounty() {
		return county;
	}

	public void setCounty(Country county) {
		this.county = county;
	}

}
