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

public class IlanDAO extends DBConnection {

    private Connection db;

    public void create(Ilan c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES("
                          + c.getIlan_id() + ", "
                          + c.getBakici_id() + ", "
                    + "'" + c.getAciklama() + "'" + ","
                          + c.isAktif() + ","
                          + c.getUcret()
                    + ");";

            String query
                    = "insert into ILAN(ilan_id,bakici_id,aciklama,aktif,ucret) " + values;
            int r = st.executeUpdate(query);

            System.out.println("DB INSERT returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Ilan c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from ilan where id=" + c.getIlan_id();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Ilan> getList() {
        List<Ilan> ilanList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from ilan";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                ilanList.add(new Ilan(
                        rs.getInt("ilan_id"),
                        rs.getInt("bakici_id"),
                        rs.getString("aciklama"),
                        rs.getBoolean("aktif"),
                        rs.getFloat("ucret")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ilanList;
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
