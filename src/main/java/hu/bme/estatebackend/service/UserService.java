package hu.bme.estatebackend.service;

import hu.bme.estatebackend.model.User;

import java.util.List;

public interface UserService {
	public void addUser(User contact);
    public List<User> listUser();
    public void removeUser(Integer id);
    public String jsonListUser();
}
