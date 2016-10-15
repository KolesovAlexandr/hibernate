package DAO.impl;

import DAO.StudentDAO;
import Factory.Sessions;
import entities.Student;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksandr_Kolesov on 10/14/2016.
 */
public class StudentDAOImpl extends Sessions implements StudentDAO<Student, Integer> {


    public StudentDAOImpl() {
    }


    public Student save(Student entity) {
        Serializable save = getCurrentSession().save(entity);
        entity.setId((Integer) save);
        return entity;
    }

    public Student findById(Integer id) {
        Student student = (Student) getCurrentSession().get(Student.class, id);
        return student;
    }

    public void update(Student entity) {
        getCurrentSession().update(entity);
    }

    public void delete(Student entity) {
        getCurrentSession().delete(entity);
    }

    public List<Student> findAll() {
        List<Student> students = getCurrentSession().createQuery("from Student").list();
        return students;
    }

    public List<Student> findWihOutStipend() {
        List<Student> students = getCurrentSession().createQuery("select s from Student s inner join s.stipend stipend where stipend.value = 0 ").list();
        return students;
    }

    public void deleteAll() {
        List<Student> students = findAll();
        for (Student student : students) {
            getCurrentSession().delete(student);
        }

    }


}
