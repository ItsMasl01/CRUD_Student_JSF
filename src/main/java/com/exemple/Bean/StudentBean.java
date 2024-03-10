package com.exemple.Bean;

import com.exemple.DAO.StudentDAO;
import com.exemple.Model.Student;
import com.exemple.Service.StudentService;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;


import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class StudentBean {


    private StudentService studentService = new StudentService();
    private Student student = new Student();
    private List<Student> students;
    private int editingStudentId;
    private int currentPage = 1;
    private int pageSize = 5;


    public void startEditing(int studentId) {
        editingStudentId = studentId;
    }
    public boolean isEditing(int studentId) {
        return editingStudentId == studentId;
    }

    public void editStudent(Student student){
        Student existingStudent = studentService.stdDAO.getStudentDAO(student.getId());
        existingStudent.setNom(student.getNom());
        existingStudent.setPrenom(student.getPrenom());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());
        studentService.edit(existingStudent);
        editingStudentId = 0;
    }

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public List<Student> getStudents() {
        int offset = (currentPage - 1) * pageSize;
        int endIndex = Math.min(offset + pageSize, students.size());
        return students.subList(offset, endIndex);
    }
    public void nextPage() {
        int totalPages = (int) Math.ceil((double) students.size() / pageSize);
        if (currentPage < totalPages) {
            currentPage++;
        }
    }
    public int getTotalPages() {
        return (int) Math.ceil((double) students.size() / pageSize);
    }
    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
        }
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public StudentService getStudentService() {
        return studentService;
    }
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public StudentBean (){
        students = studentService.selectAll();
    }



}
