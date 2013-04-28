package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.User;

import java.util.List;

public interface UserDAO {
	public User getUser(String userName);

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(Integer id);
}
