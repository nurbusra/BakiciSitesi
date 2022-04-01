/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.User;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBConnection {

    private Connection db;

    public void create(User c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "insert into user(created) values('" + c.getCreated() + "')";
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(User c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from user where id=" + c.getId();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<User> getList() {
        List<User> userList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from user";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                userList.add(new User(rs.getInt("id"), rs.getString("isim"), rs.getString("e_mail"), rs.getString("sifre"), rs.getInt("sinif"), rs.getTimestamp("created"), rs.getTimestamp("updated")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }

    public Connection getDb() throws Exception {
        if (this.db == null) {
            this.db = this.getConnection();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

}
