package com.arief.mvc.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="album")
public class Album {

    @Id
    @Column(name = "album_id",length = 4)
    private String albumId;

    @Column(name = "album_name")
    private String albumName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "album",cascade = {CascadeType.REMOVE})
    private List<Photo> photoList;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}
