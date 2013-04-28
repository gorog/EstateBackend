package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Comment;

import java.util.List;

public interface CommentDAO {

	public void addComment(Comment comment);

	public List<Comment> listComment();

	public List<Comment> listComment(long propertyId);

	public Comment getComment(long id);
}
