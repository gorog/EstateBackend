package hu.bme.estatebackend.property.dao;

import hu.bme.estatebackend.property.form.Notification;

import java.util.List;

public interface NotificationDAO {
	public void addNotification(Notification notification);

	public List<Notification> listNotification(String userName);

	public void removeNotification(Integer id);

	public Notification getNotification(long notification);
}
