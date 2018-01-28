package com.arief.mvc.models;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @Column(name = "photo_id")
    @GeneratedValue
    private int photoId;

    @Column(name = "photo_name")
    private String photoName;

    @Column(name = "photo_url")
    private String photoUrl;


    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", photoName='" + photoName + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }

    public static Photo createPhoto(String photoName,String photoUrl,Album a){
        Photo p = new Photo();
        p.setPhotoName(photoName);
        p.setPhotoUrl(photoUrl);
        p.setAlbum(a);
        return p;
    }
}
