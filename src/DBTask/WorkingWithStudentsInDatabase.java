package DBTask;

import java.sql.*;
import java.util.HashMap;

public class WorkingWithStudentsInDatabase {
    public void addStudent() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String addStudentQuery = "INSERT INTO performance(name) VALUES (?)";
            PreparedStatement prep = connection.prepareStatement(addStudentQuery);

            System.out.println("Enter name of new student");
            String name = Input.getNameInput();
            prep.setString(1, name);
            prep.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String deleteStudentQuery = "DELETE FROM performance WHERE name=?";
            PreparedStatement prep = connection.prepareStatement(deleteStudentQuery);

            System.out.println("Enter name of student you wanna exclude");
            String name = Input.getNameInput();
            prep.setString(1, name);
            prep.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String updateStudentQuery = "UPDATE performance SET name=? WHERE name=?";
            PreparedStatement prep = connection.prepareStatement(updateStudentQuery);

            System.out.println("Enter old info");
            String oldName = Input.getNameInput();
            System.out.println("Enter new info");
            String newName = Input.getNameInput();
            prep.setString(1, newName);
            prep.setString(2, oldName);
            prep.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchStudent() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String searchStudentQuery = "SELECT * FROM performance WHERE name=?";
            PreparedStatement prep = connection.prepareStatement(searchStudentQuery);

            System.out.println("Enter name you wanna find");
            String sName = Input.getNameInput();
            prep.setString(1, sName);
            prep.execute();

            ResultSet student = prep.executeQuery();
            while (student.next()) {
                System.out.println("Student info : ");
                System.out.println("id = " + student.getString("id") +
                                   "\nname = " + student.getString("name") +
                                   "\nperformance = " + student.getString("performance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
