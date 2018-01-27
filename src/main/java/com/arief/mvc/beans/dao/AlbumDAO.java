package com.arief.mvc.beans.dao;

import com.arief.mvc.models.Album;

import java.util.List;

public interface AlbumDAO {
    void save(Album a);
    List<Album> getAlbums();
    Album getAlbum(String albumId);
}
