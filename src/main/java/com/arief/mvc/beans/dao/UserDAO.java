package com.arief.mvc.beans.dao;


import com.arief.mvc.models.User;

import java.util.List;

public interface UserDAO {
    void save(User u);
    List<User> getUsers();
    User getUser(String userId);
    void delete(User u);
}
