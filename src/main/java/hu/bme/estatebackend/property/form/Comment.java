package hu.bme.estatebackend.property.form;

import hu.bme.gson.MyExclusionStrategy.Serialize;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENT")
public class Comment {
	
	@Serialize
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "USER")
	private User user;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "PROPERTY")
	private Property property;

	@Serialize
	@Column(name = "COMMENT")
	private String comment;

	@Serialize
	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;

	@Serialize
	@ManyToOne
	@JoinColumn(name = "COMMENT_ID")
	private Comment commentId;

	@OneToMany(mappedBy = "commentId")
	private Set<Comment> comments = new HashSet<Comment>();

	public Comment() {
		super();
	}

	public Comment(Integer id, User user, Property property, String comment,
			Timestamp timestamp, Comment commentId) {
		super();
		this.id = id;
		this.user = user;
		this.property = property;
		this.comment = comment;
		this.timestamp = timestamp;
		this.commentId = commentId;
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

	public Comment getCommentId() {
		return commentId;
	}

	public void setCommentId(Comment commentId) {
		this.commentId = commentId;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
