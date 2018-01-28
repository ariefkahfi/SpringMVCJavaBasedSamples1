package com.arief.mvc.beans.dao.services;

import com.arief.mvc.beans.dao.UserDAO;
import com.arief.mvc.models.Album;
import com.arief.mvc.models.Photo;
import com.arief.mvc.models.User;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.File;
import java.util.List;

@Service
public class UserService implements GenericService<User,String>{

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void save(final User user) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                userDAO.save(user);
            }
        });
    }

    public List<User> getAll() {
        return transactionTemplate.execute(new TransactionCallback<List<User>>() {
            public List<User> doInTransaction(TransactionStatus transactionStatus) {
                return userDAO.getUsers();
            }
        });
    }

    public User getOne(final String s) {
        return transactionTemplate.execute(new TransactionCallback<User>() {
            public User doInTransaction(TransactionStatus transactionStatus) {
                return userDAO.getUser(s);
            }
        });
    }

    public void deletePhotoFromThisUser(final String userId){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                User getOne = userDAO.getUser(userId);
                List<Album> albumList = getOne.getAlbumList();

                if(albumList!=null && albumList.size() > 0) {
                    for (Album a : albumList) {

                        List<Photo> photoList = a.getPhotoList();
                        if(photoList !=null && photoList.size() > 0 ){
                            for (Photo p : photoList) {
                                String photoUrl = p.getPhotoUrl();
                                String fileName = photoUrl.substring(photoUrl.lastIndexOf("/") + 1, photoUrl.length());
                                File file = new File("/usr/local/apache/uploads/" + fileName);
                                if (file.delete()) {
                                    System.out.println("photo deleted ..." + file.getAbsolutePath());
                                }
                            }
                        }else{
                            System.out.println("photoList empty or null");
                        }

                    }
                }else{
                    System.out.println("albumList null or empty");
                }

            }
        });
    }

    public List<Album> getUsersAlbum(final String userId){
        return transactionTemplate.execute(new TransactionCallback<List<Album>>() {
            public List<Album> doInTransaction(TransactionStatus transactionStatus) {
                User getOne = userDAO.getUser(userId);
                if(getOne !=null){
                    Hibernate.initialize(getOne.getAlbumList());
                    return getOne.getAlbumList();
                }else{
                    return null;
                }
            }
        });
    }

    public void delete(final User user) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                userDAO.delete(user);
            }
        });
    }
}
