package com.arief.mvc.beans.dao.services;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T , ID extends Serializable> {
    void save(T t);
    List<T> getAll();
    T getOne (ID id);
    void delete(T t);
}
