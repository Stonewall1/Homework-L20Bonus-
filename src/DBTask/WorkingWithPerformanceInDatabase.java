package DBTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkingWithPerformanceInDatabase {
    public void updatePerformance() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String updatePerformanceQuery = "UPDATE performance SET performance=? WHERE name=?";
            PreparedStatement prep = connection.prepareStatement(updatePerformanceQuery);

            System.out.println("Enter name of student whose performance you wanna edit");
            String name = Input.getNameInput();
            System.out.println("Enter new performance");
            String newPerf = Input.getPerformanceInput();
            prep.setString(1, newPerf);
            prep.setString(2, name);
            prep.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchPerformance() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String searchPerformanceQuery = "SELECT * FROM performance WHERE performance=?";
            PreparedStatement prep = connection.prepareStatement(searchPerformanceQuery);

            System.out.println("Enter performance you wanna find");
            String perf = Input.getPerformanceInput();
            prep.setString(1, perf);
            prep.execute();

            ResultSet studentsPerf = prep.executeQuery();
            while (studentsPerf.next()) {
                System.out.println("Student info : ");
                System.out.println("id = " + studentsPerf.getString("id") +
                                   "\nname = " + studentsPerf.getString("name") +
                                   "\nperformance = " + studentsPerf.getString("performance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
