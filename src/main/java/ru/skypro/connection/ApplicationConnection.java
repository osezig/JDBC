package ru.skypro.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationConnection {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/skypro";
        String username = "postgres";
        String password = "2wsxZXC222";
        return DriverManager.getConnection(url,username,password);
    }
    public PreparedStatement getPreparedStatement (String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}