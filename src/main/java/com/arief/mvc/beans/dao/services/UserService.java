package com.arief.mvc.beans.dao.services;

import com.arief.mvc.beans.dao.UserDAO;
import com.arief.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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

    public void delete(final User user) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                userDAO.delete(user);
            }
        });
    }
}
