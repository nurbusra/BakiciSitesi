/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.MusteriXilan;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusteriXilanDAO extends DBConnection {

    private Connection db;

    public void create(MusteriXilan c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES("
                    + "'" + c.getId()
                    + "'" + ", "
                    + "'" + c.getIlan_id() + "'" + ", "
                    + c.getMusteri_id() + "'" + ", "
                    + c.isOdendi()
                    + ");";

            String query = "insert into MUSTERIXILAN(id,ilan_id,musteri_id,odendi) " + values;
            int r = st.executeUpdate(query);
            
            System.out.println("DB INSERT returned with: " + r);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(MusteriXilan c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from musterixilan where id=" + c.getId();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<MusteriXilan> getList() {
        List<MusteriXilan> musterixilanList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from musterixilan";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                musterixilanList.add(new MusteriXilan(rs.getInt("id"), rs.getInt("ilan_id"), rs.getInt("musteri_id"), rs.getBoolean("odendi")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return musterixilanList;
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
