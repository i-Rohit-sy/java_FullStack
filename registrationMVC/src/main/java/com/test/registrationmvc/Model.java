package com.test.registrationmvc;

import javax.sql.rowset.spi.SyncResolver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
    private String name;
    private String email;
    private String password;
    private String gender;
    private Connection connection;
    private PreparedStatement pstmt;
    private int row;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int register(){
        try {
            connection = JDBCutil.getDBConnection();
            String sql = "INSERT INTO users(name,email,password,gender) VALUES (? , ?, ?, ? )";
            pstmt =  connection.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setString(3,password);
            pstmt.setString(4,gender);

            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                JDBCutil.closeResource(connection,pstmt);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return row;
    }


}
