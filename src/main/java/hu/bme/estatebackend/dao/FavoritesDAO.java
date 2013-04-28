package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Favorites;

import java.util.List;

public interface FavoritesDAO {
	public List<Favorites> listFavorites();

	public Favorites getFavorites(long id);
}
