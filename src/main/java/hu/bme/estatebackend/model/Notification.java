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
@Table(name = "NOTIFICATION")
public class Notification {

	@Serialize
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "PROPERTY_ID")
	private Property property;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	private NotificationType type;

	@Serialize
	@Column(name = "CONTENT")
	private String content;

	@Serialize
	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;

	@Serialize
	@Column(name = "ISREAD")
	private boolean isread;

	public Notification() {
		super();
	}

	public Notification(Integer id, User user, Property property,
			NotificationType type, String content, Timestamp timestamp) {
		super();
		this.id = id;
		this.user = user;
		this.property = property;
		this.type = type;
		this.content = content;
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

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isIsread() {
		return isread;
	}

	public void setIsread(boolean isread) {
		this.isread = isread;
	}

	public String toString() {
		return ("{ \"id\":" + id + ", \"user\": \"" + user.getUsername()
				+ "\", \"property\": " + property.getId() + ", \"type\": "
				+ type.getId() + ", \"content\": \"" + content
				+ "\", \"timestamp\": \"" + timestamp + "\", \"isread\": "
				+ isread + " }");
	}
}
