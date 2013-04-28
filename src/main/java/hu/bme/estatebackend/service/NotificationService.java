package hu.bme.estatebackend.service;

import hu.bme.estatebackend.model.Notification;

import java.util.List;

public interface NotificationService {
	public void addNotification(Notification contact);

	public List<Notification> listNotification(String userNamev);

	public void removeNotification(Integer id);

	public String jsonListNotification(String userName);

	public String getNotificationJson(long notificationId);
}
