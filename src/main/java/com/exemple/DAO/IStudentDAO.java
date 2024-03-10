package com.exemple.DAO;

import com.exemple.Model.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> selectAllDAO() ;
    Student getStudentDAO(int id);
    void editDAO(Student student);
    void deleteDAO(int id);
    void insertDAO(Student student);
    boolean emailExisteDeja(String email);
}
