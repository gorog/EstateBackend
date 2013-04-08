package hu.bme.estatebackend.property.service;

import hu.bme.estatebackend.property.form.User;

import java.util.List;

public interface UserService {
	public void addUser(User contact);
    public List<User> listUser();
    public void removeUser(Integer id);
    public String jsonListUser();
}
