package onlinebankingobjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Cashin {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/onlinebanking";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public void cashIn(int accountId, double amount) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            
            String updateQuery = "UPDATE Account SET balance = balance + ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setDouble(1, amount);
            updateStatement.setInt(2, accountId);
            updateStatement.executeUpdate();
            updateStatement.close();

           
            String insertQuery = "INSERT INTO Transaction (amount, name, account_ID, date) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setDouble(1, amount);
            insertStatement.setString(2, "Cash In");
            insertStatement.setInt(3, accountId);
            insertStatement.setDate(4, new java.sql.Date(new Date().getTime()));
            insertStatement.executeUpdate();
            insertStatement.close();

            System.out.println("Cash-in successful. Account ID: " + accountId + ", Amount: " + amount);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
