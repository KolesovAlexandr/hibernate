package DAO;

import entities.Stipend;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksandr_Kolesov on 10/14/2016.
 */
public interface StipendDAO<T, Id extends Serializable> {
    T save(T entity);

    T findById(Id id);

    void update(T entity);

    void delete(T entity);

    List<T> findAll();

    List<T> findZeroStipend();

    void deleteAll();

}
