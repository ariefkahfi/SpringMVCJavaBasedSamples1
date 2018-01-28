package com.arief.mvc.beans.dao.services;

import com.arief.mvc.beans.dao.PhotoDAO;
import com.arief.mvc.models.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class PhotoService implements GenericService<Photo,Integer>{

    @Autowired
    private PhotoDAO photoDAO;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void save(final Photo photo) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                photoDAO.save(photo);
            }
        });
    }

    public List<Photo> getAll() {
        return transactionTemplate.execute(new TransactionCallback<List<Photo>>() {
            public List<Photo> doInTransaction(TransactionStatus transactionStatus) {
                return photoDAO.getPhotos();
            }
        });
    }

    public Photo getOne(final Integer integer) {
        return transactionTemplate.execute(new TransactionCallback<Photo>() {
            public Photo doInTransaction(TransactionStatus transactionStatus) {
                return photoDAO.getPhoto(integer);
            }
        });
    }

    public void delete(final Photo photo) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                photoDAO.delete(photo);
            }
        });
    }
}
