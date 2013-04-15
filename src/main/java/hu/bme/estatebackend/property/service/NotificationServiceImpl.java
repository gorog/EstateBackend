package hu.bme.estatebackend.property.service;

import hu.bme.estatebackend.property.dao.NotificationDAO;
import hu.bme.estatebackend.property.form.Notification;
import hu.bme.estatebackend.property.form.Property;
import hu.bme.gson.MyExclusionStrategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationDAO notificationDAO;

	@Transactional
	public void addNotification(Notification notification) {
		notificationDAO.addNotification(notification);
	}

	@Transactional
	public List<Notification> listNotification(String userName) {
		return notificationDAO.listNotification(userName);
	}

	@Transactional
	public void removeNotification(Integer id) {
		notificationDAO.removeNotification(id);
	}

	@Transactional
	public String jsonListNotification(String userName) {
		Gson gson = new GsonBuilder()
		.setExclusionStrategies(new MyExclusionStrategy(null))
		.serializeNulls().create();

		String json = gson.toJson(notificationDAO.listNotification(userName));
		return json;
	}

	@Transactional
	public String getNotificationJson(long notificationId) {
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new MyExclusionStrategy(null))
				.serializeNulls().create();

		
		String json = gson.toJson(notificationDAO
				.getNotification(notificationId));
		return json;
	}
}
