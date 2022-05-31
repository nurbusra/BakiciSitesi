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
    private BakiciDAO bakiciDao;

    public BakiciDAO getBakiciDao() {
        if(this.bakiciDao == null) this.bakiciDao = new BakiciDAO();
        return bakiciDao;
    }

    public void setBakiciDao(BakiciDAO bakiciDao) {
        this.bakiciDao = bakiciDao;
    }

    public void create(Ilan c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES("
                          + c.getBakici().getBakici_id() + ", "
                    + "'" + c.getAciklama() + "'" + ","
                          + c.getUcret()
                    + ");";

            String query
                    = "insert into ILAN(bakici_id,aciklama,ucret) " + values;
            System.out.println(query);
            int r = st.executeUpdate(query);

            System.out.println("DB INSERT returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void delete(Ilan c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from ILAN where ilan_id=" + c.getIlan_id();
            int r = st.executeUpdate(query);
            
            System.out.println("DB DELETE returned with: " + r);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void update(Ilan c) {
        try {
            Statement st = this.getDb().createStatement();

            String query;
            query = "UPDATE ILAN " + "\n" +
                    "SET " + "\n" +
                        "aciklama = " + "'" + c.getAciklama() + "'" + ",\n" +
                        "ucret = " + c.getUcret() + ",\n" +
                        "aktif = " + c.getAktif() + "\n" +
                    "WHERE ilan_id = " + c.getIlan_id() + ";";
                                   
            int r = st.executeUpdate(query);
            
            System.out.println("DB UPDATE returned with: " + r);
            
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
    
    public Ilan findById (int id){
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from ILAN where ilan_id=";
            query=query+String.valueOf(id);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                return (new Ilan(
                    rs.getInt("ilan_id"),
                    rs.getInt("bakici_id"),
                    rs.getString("aciklama"),
                    rs.getBoolean("aktif"),
                    rs.getFloat("ucret")
                    )
                );
            }
        
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
            
        return null;
    }
   
    public List<Ilan> retByBakiciId(int id){
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from ILAN where bakici_id=";
            query=query+String.valueOf(id);
            ResultSet rs = st.executeQuery(query);
            
            List<Ilan> out = new ArrayList<Ilan>();

            while (rs.next()) {
                out.add(new Ilan(
                    rs.getInt("ilan_id"),
                    rs.getInt("bakici_id"),
                    rs.getString("aciklama"),
                    rs.getBoolean("aktif"),
                    rs.getFloat("ucret")
                    )
                );
            }
            
            return out;
        
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
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
