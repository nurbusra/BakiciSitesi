/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DBConnection {
    
    private final String db_url = "";
    private final String db_username = "postgres";
    private final String db_pass = "12345";
    public Connection connect() {
        Connection c = null;
        
        // Connect to Database
        try {
            Class.forName("org.postgres.Driver");
            c = DriverManager.getConnection(db_url, db_username, db_pass);
        } catch(Exception e) {
            System.out.println("Err: " + e.getMessage() );
        }
        return c; 
    }
}
