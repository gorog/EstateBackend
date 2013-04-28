package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Offer;

import java.util.List;

public interface OfferDAO {
	public List<Offer> listOffer();

	public Offer getOffer(long id);
}
