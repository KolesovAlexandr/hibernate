package service.impl;

import DAO.impl.StipendDAOImpl;
import entities.Stipend;
import service.StipendService;

import java.util.List;

/**
 * Created by Aleksandr_Kolesov on 10/15/2016.
 */
public class StipendServiceImpl implements StipendService<Stipend, Integer> {
    private static StipendDAOImpl StipendDAO;

    public StipendServiceImpl() {
        StipendDAO = new StipendDAOImpl();
    }

    public Stipend save(Stipend entity) {
        StipendDAO.openCurrentSessionwithTransaction();
        Stipend newEntity = StipendDAO.save(entity);
        StipendDAO.closeCurrentSessionwithTransaction();
        return newEntity;
    }

    public Stipend findById(Integer id) {
        StipendDAO.openCurrentSession();
        Stipend Stipend = StipendDAO.findById(id);
        StipendDAO.closeCurrentSession();
        return Stipend;
    }

    public void update(Stipend entity) {
        StipendDAO.openCurrentSessionwithTransaction();
        StipendDAO.update(entity);
        StipendDAO.closeCurrentSessionwithTransaction();
    }

    public void delete(Integer id) {
        StipendDAO.closeCurrentSessionwithTransaction();
        Stipend delete = StipendDAO.findById(id);
        StipendDAO.delete(delete);
        StipendDAO.closeCurrentSessionwithTransaction();

    }

    public List<Stipend> findAll() {
        StipendDAO.openCurrentSession();
        List<Stipend> Stipends = StipendDAO.findAll();
        StipendDAO.closeCurrentSession();
        return Stipends;
    }

    public List<Stipend> findZeroStipend() {
        StipendDAO.openCurrentSession();
        List<Stipend> Stipends = StipendDAO.findZeroStipend();
        StipendDAO.closeCurrentSession();
        return Stipends;

    }

    public void deleteAll() {
        StipendDAO.openCurrentSessionwithTransaction();
        StipendDAO.deleteAll();
        StipendDAO.closeCurrentSessionwithTransaction();

    }
}
