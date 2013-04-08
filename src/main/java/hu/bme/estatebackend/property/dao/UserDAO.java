package hu.bme.estatebackend.property.dao;

import hu.bme.estatebackend.property.form.User;

import java.util.List;

public interface UserDAO {
	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(Integer id);
}
