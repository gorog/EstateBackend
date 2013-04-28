package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Notification;

import java.util.List;

public interface NotificationDAO {
	public void addNotification(Notification notification);

	public List<Notification> listNotification(String userName);

	public void removeNotification(Integer id);

	public Notification getNotification(long notification, String userName);
}
