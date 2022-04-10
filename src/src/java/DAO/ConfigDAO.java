/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Config;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConfigDAO extends DBConnection {

    private Connection db;

    public void create(Config c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES("
                    + "'" + c._getOption() + "'" + ", "
                    + "'" + c._getValue() + "'"
                    + ");";

            String query
                    = "insert into CONFIG(option,value) " + values;
            int r = st.executeUpdate(query);

            System.out.println("DB INSERT returned with: " + r);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Config c) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "delete from config where option=" + c._getOption();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Config c) {

        try {
            Statement st = this.getDb().createStatement();

            String query;
            query = "UPDATE CONFIG " + "\n"
                    + "SET " + "\n"
                    + "_value = " + "'" + c._getValue() + "'" + "\n"
                    + "WHERE _option = " + c._getOption() + ";";

            int r = st.executeUpdate(query);

            System.out.println("DB UPDATE returned with: " + r);

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
                configList.add(new Config(rs.getString("_option"), rs.getString("_value")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return configList;
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
