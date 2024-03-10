package com.exemple.Service;

import com.exemple.Bean.StudentBean;
import com.exemple.DAO.StudentDAO;
import com.exemple.Model.Student;

import java.util.List;
import java.util.ResourceBundle;

public class StudentService {
    private String message = " ";
    public StudentDAO stdDAO = new StudentDAO();

    public StudentService() {
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public StudentDAO getStdDAO() {
        return stdDAO;
    }
    public void setStdDAO(StudentDAO stdDAO) {
        this.stdDAO = stdDAO;
    }
    public List<Student> selectAll() {
        return stdDAO.selectAllDAO();
    }
    public void insert(Student std) {
        ResourceBundle messages = ResourceBundle.getBundle("messages");
        stdDAO.insertDAO(std);
        setMessage(messages.getString("msgConfirmInsert"));
    }
    public void delete(int id) {
        stdDAO.deleteDAO(id);
    }
    public void edit(Student student) {
        ResourceBundle messages = ResourceBundle.getBundle("messages");
        stdDAO.editDAO(student);
        setMessage(messages.getString("msgConfirmEdit"));
    }
}
