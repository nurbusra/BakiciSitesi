/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Config;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class ConfigDAO extends DBConnection {

    private Connection db;

    public void create(Config c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "insert into config(created) values('" + c.getCreated() + "')";
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Config c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from config where option=" + c.getOption();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Config> getList() {
        List<Config> configList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from config";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                configList.add(new Config(rs.getString("option"), rs.getString("value"), rs.getTimestamp("created"), rs.getTimestamp("updated")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return configList;
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
