package com.exemple.DAO;
import com.exemple.Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentDAO implements IStudentDAO{
    public StudentDAO() {
    }

    @Override
    public List<Student> selectAllDAO() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DB.getConnection();
            String query = "SELECT * FROM studentgi";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                Student student = new Student(id, nom, prenom, email, age);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeConnection(connection);
        }
        return students;
    }

    @Override
    public Student getStudentDAO(int id) {
        Student student = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DB.getConnection();
            String query = "SELECT * FROM studentgi WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                student = new Student(id, nom, prenom, email, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeConnection(connection);
        }
        return student;
    }
    @Override
    public void editDAO(Student student) {
        System.out.println(student.nom);
        System.out.println(student.getEmail());
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DB.getConnection();
            String query = "UPDATE studentgi SET nom=?,prenom=?,email=?,age=? where id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getNom());
            preparedStatement.setString(2, student.getPrenom());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setInt(5, student.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("edit dao worked");
    }

    @Override
    public void deleteDAO(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DB.getConnection();
            String query = "DELETE FROM studentgi WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("cc");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeConnection(connection);
        }
    }

    @Override
    public void insertDAO(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            String query = "INSERT INTO studentgi(nom,prenom,email,age) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.nom);
            preparedStatement.setString(2, student.prenom);
            preparedStatement.setString(3, student.email);
            preparedStatement.setInt(4, student.age);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeConnection(connection);
        }
    }

    @Override
    public boolean emailExisteDeja(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean emailExists = false;

        try {
            connection = DB.getConnection();
            String query = "SELECT COUNT(*) FROM studentgi WHERE email = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                emailExists = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeConnection(connection);
        }
        return emailExists;
    }


}
