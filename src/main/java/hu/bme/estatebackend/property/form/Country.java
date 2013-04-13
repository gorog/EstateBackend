package hu.bme.estatebackend.property.form;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "SHORT")
	private String short_name;

	@Column(name = "NAME")
	private String name;

	/*
	@OneToMany(mappedBy = "country")
	private Set<County> countys;

	*/
	
	public Country() {
		super();
	}

	public Country(Integer id, String short_name, String name) {
		super();
		this.id = id;
		this.short_name = short_name;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
	public Set<County> getCountys() {
		return countys;
	}

	public void setCountys(Set<County> county) {
		this.countys = county;
	}
*/
}
