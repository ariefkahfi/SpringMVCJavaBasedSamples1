package com.arief.mvc.beans.dao;

import com.arief.mvc.models.Photo;

import java.util.List;

public interface PhotoDAO {
    void save(Photo p);
    List<Photo> getPhotos();
    Photo getPhoto(int photoId);
    void delete(Photo p);
}
