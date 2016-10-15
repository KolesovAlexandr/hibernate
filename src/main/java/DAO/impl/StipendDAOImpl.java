package DAO.impl;

import DAO.StipendDAO;
import Factory.AbstractSessionFactory;
import entities.Stipend;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksandr_Kolesov on 10/15/2016.
 */
public class StipendDAOImpl extends AbstractSessionFactory implements StipendDAO<Stipend, Integer> {
    public Stipend save(Stipend entity) {
        Serializable save = getCurrentSession().save(entity);
        entity.setId((Integer) save);
        return entity;
    }

    public Stipend findById(Integer id) {
        Stipend Stipend = (Stipend) getCurrentSession().get(Stipend.class, id);
        return Stipend;
    }

    public void update(Stipend entity) {
        getCurrentSession().update(entity);
    }

    public void delete(Stipend entity) {
        getCurrentSession().delete(entity);
    }

    public List<Stipend> findAll() {
        List<Stipend> Stipends = getCurrentSession().createQuery("from Stipend").list();
        return Stipends;
    }


    public List<Stipend> findZeroStipend() {
        List<Stipend> Stipends = getCurrentSession().createQuery("from Stipend s where s.value = 0").list();
        return Stipends;
    }

    public void deleteAll() {
        List<Stipend> Stipends = findAll();
        for (Stipend Stipend : Stipends) {
            getCurrentSession().delete(Stipend);
        }

    }
}
