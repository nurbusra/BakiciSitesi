/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.User_;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBConnection {

    private Connection db;

    public void create(User_ c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES(" + 
                    "'" + c.getIsim() + "'" + ", " +
                    "'" + c.getEmail() + "'" + ", " +
                    "'" + c.getSifre() + "'" + ", " +
                    c.getSinif() + 
                    ");";
            
            String query = 
                    "insert into USER_(isim, email, sifre, sinif) " + values;
                            
            int r = st.executeUpdate(query);
            
            System.out.println("DB INSERT returned with: " + r);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(User_ c) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "delete from USER_ where user_id=" + c.getUser_id();          
            int r = st.executeUpdate(query);
            
            System.out.println("DB DELETE returned with: " + r);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<User_> getList() {
        List<User_> userList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from USER_";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                userList.add(new User_(
                        rs.getInt("user_id"),
                        rs.getString("isim"),
                        rs.getString("email"), 
                        rs.getString("sifre"),
                        rs.getInt("sinif")
                    )
                );
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }

    public Connection getDb() throws Exception {
        if (this.db == null) {
            this.db = getConnection();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
}
