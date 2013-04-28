package hu.bme.estatebackend.service;

import hu.bme.estatebackend.dao.UserDAO;
import hu.bme.estatebackend.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void addUser(User contact) {
		userDAO.addUser(contact);
	}

	@Transactional
	public List<User> listUser() {
		return userDAO.listUser();
	}

	@Transactional
	public void removeUser(Integer id) {
		userDAO.removeUser(id);
	}

	@Transactional
	public String jsonListUser() {

		Gson gson = new Gson();

		String json = gson.toJson(userDAO.listUser());
		return json;
	}
}
