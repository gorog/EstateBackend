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
@Table(name = "FAVORITES")
public class Favorites {
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
	@JoinColumn(name = "PROPERTY_ID")
	private Property property;

	public Favorites() {
		super();
	}

	public Favorites(Integer id, User user, Property property) {
		super();
		this.id = id;
		this.user = user;
		this.property = property;
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

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
	public String toString(){
		return ("{ \"id\":" + id + ", \"user\": \"" + user.getUsername()
				+ "\", \"property\": " + property.getId() + " }");
	}

}
