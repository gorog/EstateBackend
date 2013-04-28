package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Comment;
import hu.bme.estatebackend.model.Property;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addComment(Comment comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}
	
	public List<Comment> listComment() {
		return sessionFactory.getCurrentSession()
				.createQuery("select c from Comment c").list();
	}

	public List<Comment> listComment(long propertyId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"select c from Comment c Left Join c.property p where p.id = ?")
				.setLong(0, propertyId).list();
	}

	public Comment getComment(long id) {
		return (Comment) sessionFactory.getCurrentSession()
				.createQuery("select c from Comment c where id = ?")
				.setLong(0, id).uniqueResult();
	}

}
