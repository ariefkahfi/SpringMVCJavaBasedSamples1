package com.arief.mvc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id",length = 4)
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.REMOVE})
    private List<Album> albumList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public static User createModel(String userId ,String userName){
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setAlbumList(new ArrayList<Album>());
        return user;
    }
}
