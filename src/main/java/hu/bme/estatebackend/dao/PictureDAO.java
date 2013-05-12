package hu.bme.estatebackend.dao;

import hu.bme.estatebackend.model.Picture;

import java.util.List;

public interface PictureDAO {
	public void addPicture(Picture picture);

	public List<Picture> listPicture(long property);

	public void removePicture(Integer id);

	public Picture getPicture(long picture);

	public String getPictureUrl(long picture);
}
