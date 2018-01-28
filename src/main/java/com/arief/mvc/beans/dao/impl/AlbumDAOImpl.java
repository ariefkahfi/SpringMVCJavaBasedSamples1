package com.arief.mvc.beans.dao.impl;

import com.arief.mvc.beans.dao.AlbumDAO;
import com.arief.mvc.models.Album;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumDAOImpl implements AlbumDAO{

    @Autowired
    private SessionFactory sessionFactory;


    public void save(Album a) {
        sessionFactory
                .getCurrentSession()
                .save(a);
    }

    public List<Album> getAlbums() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Album").list();
    }

    public Album getAlbum(String albumId) {
        return sessionFactory
                    .getCurrentSession()
                    .get(Album.class,albumId);
    }
}
