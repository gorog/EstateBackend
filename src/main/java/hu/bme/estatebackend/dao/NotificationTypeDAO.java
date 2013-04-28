package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.NotificationType;

import java.util.List;

public interface NotificationTypeDAO {
	public List<NotificationType> listNotificationType();

	public NotificationType getNotificationType(long id);
}
