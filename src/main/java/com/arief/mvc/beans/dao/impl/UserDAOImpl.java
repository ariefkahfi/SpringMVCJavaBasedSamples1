package com.arief.mvc.beans.dao.impl;

import com.arief.mvc.beans.dao.UserDAO;
import com.arief.mvc.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User u) {
        sessionFactory
                .getCurrentSession()
                .save(u);
    }

    public List<User> getUsers() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from User")
                .list();
    }

    public User getUser(String userId) {
        return sessionFactory
                .getCurrentSession()
                .get(User.class,userId);
    }

    public void delete(User u) {
        sessionFactory
                .getCurrentSession()
                .remove(u);
    }
}
