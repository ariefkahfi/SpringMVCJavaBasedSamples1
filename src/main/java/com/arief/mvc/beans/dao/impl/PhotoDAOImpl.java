package com.arief.mvc.beans.dao.impl;

import com.arief.mvc.beans.dao.PhotoDAO;
import com.arief.mvc.models.Photo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoDAOImpl implements PhotoDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Photo p) {
        sessionFactory
                .getCurrentSession()
                .save(p);
    }

    public List<Photo> getPhotos() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Photo")
                .list();
    }

    public Photo getPhoto(int photoId) {
        return sessionFactory
                .getCurrentSession()
                .get(Photo.class,photoId);
    }

    public void delete(Photo p) {
        sessionFactory
                .getCurrentSession()
                .remove(p);
    }
}
