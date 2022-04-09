/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DBConnection {
    
    private static Connection c;
    
    private static final String db_url = "jdbc:postgresql://127.0.0.1:5432/bakicisitesi_db";
    private static final String db_username = "postgres";
    private static final String db_pass = "12345";
    
    private static Connection connect() {       
        // Connect to Database
        try {
            Class.forName("org.postgresql.Driver");
            DBConnection.c = DriverManager.getConnection(db_url, db_username, db_pass);
        } catch(Exception e) {
            System.out.println("Err: " + e.getMessage() );
            e.printStackTrace();
        }
        return c; 
    }
    
    public static Connection getConnection() throws Exception {
        if ( DBConnection.c != null && ! DBConnection.c.isClosed() ) {
            return DBConnection.c;
        }
        else {
            return DBConnection.connect();
        }
    }
}
