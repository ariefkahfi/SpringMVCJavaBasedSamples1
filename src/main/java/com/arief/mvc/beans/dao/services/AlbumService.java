package com.arief.mvc.beans.dao.services;

import com.arief.mvc.beans.dao.AlbumDAO;
import com.arief.mvc.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class AlbumService implements GenericService<Album,String>{


    @Autowired
    private AlbumDAO albumDAO;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void save(final Album album) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                albumDAO.save(album);
            }
        });
    }

    public List<Album> getAll() {
        return transactionTemplate.execute(new TransactionCallback<List<Album>>() {
            public List<Album> doInTransaction(TransactionStatus transactionStatus) {
                return albumDAO.getAlbums();
            }
        });
    }

    public Album getOne(final String s) {
        return transactionTemplate.execute(new TransactionCallback<Album>() {
            public Album doInTransaction(TransactionStatus transactionStatus) {
                return albumDAO.getAlbum(s);
            }
        });
    }

    public void delete(Album album) {
        // not implemented yet
    }
}
