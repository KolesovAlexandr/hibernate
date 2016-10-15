package service.impl;

import DAO.impl.StudentDAOImpl;
import entities.Student;
import service.StudentService;

import java.util.List;

/**
 * Created by Aleksandr_Kolesov on 10/14/2016.
 */
public class StudentServiceImpl implements StudentService<Student, Integer> {
    private static StudentDAOImpl studentDAO;

    public StudentServiceImpl() {
        studentDAO = new StudentDAOImpl();
    }

    public Student save(Student entity) {
        studentDAO.openCurrentSessionwithTransaction();
        Student newEntity = studentDAO.save(entity);
        studentDAO.closeCurrentSessionwithTransaction();
        return newEntity;
    }

    public Student findById(Integer id) {
        studentDAO.openCurrentSession();
        Student student = studentDAO.findById(id);
        studentDAO.closeCurrentSession();
        return student;
    }

    public void update(Student entity) {
        studentDAO.openCurrentSessionwithTransaction();
        studentDAO.update(entity);
        studentDAO.closeCurrentSessionwithTransaction();
    }

    public void delete(Integer id) {
        studentDAO.closeCurrentSessionwithTransaction();
        Student delete = studentDAO.findById(id);
        studentDAO.delete(delete);
        studentDAO.closeCurrentSessionwithTransaction();

    }

    public List<Student> findAll() {
        studentDAO.openCurrentSession();
        List<Student> students = studentDAO.findAll();
        studentDAO.closeCurrentSession();
        return students;
    }

    public List<Student> findWihOutStipend() {
        studentDAO.openCurrentSession();
        List<Student> students = studentDAO.findWihOutStipend();
        studentDAO.closeCurrentSession();
        return students;

    }

    public void deleteAll() {
        studentDAO.openCurrentSessionwithTransaction();
        studentDAO.deleteAll();
        studentDAO.closeCurrentSessionwithTransaction();

    }
}
