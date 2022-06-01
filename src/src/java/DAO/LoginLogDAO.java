/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.LoginLog;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Merve
 */
public class LoginLogDAO extends DBConnection {

    private Connection db;

    public void create(LoginLog c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES("
                    + c.getUser_id() + ","
                    + "'" + c.getIp_addr() + "'"
                    + ");";

            String query
                    = "insert into LOGIN_LOG(user_id, ip_addr) " + values;

            System.out.println(query);
            int r = st.executeUpdate(query);

            System.out.println("DB INSERT returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(LoginLog c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from login_log where id=" + c.getLogin_id();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(LoginLog c) {

        try {
            Statement st = this.getDb().createStatement();

            String query;
            query = "UPDATE LOGIN_LOG " + "\n"
                    + "SET " + "\n"
                    + "user_id = " + c.getUser_id()
                    + "tarih = " + c.getTarih() + "\n"
                    + "ip_addr = " + c.getIp_addr() + "\n" 
                    + "WHERE login_id = " + c.getLogin_id() + ";";
            System.out.println(query);
            int r = st.executeUpdate(query);

            System.out.println("DB UPDATE returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<LoginLog> getList() {
        List<LoginLog> loginlogList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from login_log";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                loginlogList.add(new LoginLog(
                        rs.getInt("login_id"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("tarih"),
                        rs.getString("ip_addr")
                    )
                );
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return loginlogList;
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
