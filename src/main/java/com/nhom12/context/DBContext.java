package com.nhom12.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
    public Connection getConnection() throws Exception
    {
        Connection conn = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/topicmana";
            String username = "root";
<<<<<<< Updated upstream
            String password = "01669871043";
=======
            String password = "Sang111#######";
>>>>>>> Stashed changes
            conn = DriverManager.getConnection(dbURL, username, password); 
        }
        catch(SQLException e)
        {
            for(Throwable t : e)
                t.printStackTrace();
        }  
        return conn;
    }
    // Kiểm tra kết nối 
    public static void main(String[] args) {
        try{
            System.out.println(new DBContext().getConnection());
        }
        catch(Exception e)
        {
        }
    }
    
}
