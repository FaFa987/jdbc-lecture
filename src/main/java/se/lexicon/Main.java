package se.lexicon;

import java.sql.*;


public class Main {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "1234");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM task");

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("title") + " " + resultSet.getString("_description")
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