package se.lexicon;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "1234");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM courses");

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("course_id") + " " + resultSet.getString("course_name")
                );
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (resultSet != null && resultSet.isClosed()) {
                    resultSet.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}