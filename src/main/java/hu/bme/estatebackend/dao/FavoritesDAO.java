package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Favorites;

import java.util.List;

public interface FavoritesDAO {
	public void addFavorites(Favorites favorites);

	public List<Favorites> listFavorites(String userName);

	public Favorites getFavorites(long id, String userName);

	public void removeFavorites(Integer id, String userName);

}
