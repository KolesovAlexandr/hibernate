package service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksandr_Kolesov on 10/15/2016.
 */
public interface StipendService<T, Id extends Serializable> {
    T save(T entity);

    T findById(Id id);

    void update(T entity);

    void delete(Id id);

    List<T> findAll();

    List<T> findZeroStipend();

    void deleteAll();
}
