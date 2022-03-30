/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Ilan;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class IlanDAO extends DBConnection {

    private Connection db;

    public void createIlan(Ilan c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "insert into ilan(created) values('" + c.getCreated() + "')";
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Ilan c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from ilan where id=" + c.getId();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Ilan> getIlanList() {
        List<Ilan> ilanList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from ilan";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                ilanList.add(new Ilan(rs.getInt("id"), rs.getInt("bakici_id"), rs.getString("aciklama"), rs.getBoolean("aktif"), rs.getFloat("ucret"), rs.getTimestamp("created"), rs.getTimestamp("updated")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ilanList;
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
