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
                    + "'" + c.getId() + "'" + ", "
                    + "'" + c.getIp_addr() + "'" + ", "
                    + "'" + c.getTarih() + "'" + ", "
                    + c.getUser_id()
                    + ");";

            String query = "insert into LOGINLOG(id,ip_addr, tarih ,user_id) " + values;

            int r = st.executeUpdate(query);
            
            System.out.println("DB INSERT returned with: " + r);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(LoginLog c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from loginlog where id=" + c.getId();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<LoginLog> getList() {
        List<LoginLog> loginlogList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from loginlog";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                loginlogList.add(new LoginLog(rs.getInt("id"), rs.getString("ip_addr"), rs.getTimestamp("tarih"), rs.getInt("user_id")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
