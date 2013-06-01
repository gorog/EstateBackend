package hu.bme.estatebackend.model;

import hu.bme.gson.MyExclusionStrategy.Serialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Serialize
	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Serialize
	@Column(name = "NAME")
	private String name;

	@Serialize
	@Column(name = "Profession")
	private String profession;

	@Serialize
	@Column(name = "PHONE")
	private String phone;

	@Serialize
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ENABLED")
	private boolean enabled;

	public User() {
		super();
	}

	public User(Integer id, String username, String password, String name,
			String profession, String phone, String email, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.profession = profession;
		this.phone = phone;
		this.email = email;
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
