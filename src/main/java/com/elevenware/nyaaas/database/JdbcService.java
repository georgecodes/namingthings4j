package com.elevenware.nyaaas.database;

import com.elevenware.nyaaas.model.Word;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcService {

    private Connection conn;

    public JdbcService(String jdbcString, String userName, String password, String jdbcDriverClass) {

        try {
            Class.forName(jdbcDriverClass);
            conn = DriverManager.getConnection(jdbcString, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveWord(Word word) {
        try {
            Statement statement = conn.createStatement();
            statement.execute("")
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
