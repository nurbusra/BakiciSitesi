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
    private IlanDAO ilanDao;
    private MusteriDAO musteriDao;

    public IlanDAO getIlanDao() {
        if(this.ilanDao == null) this.ilanDao = new IlanDAO();
        return ilanDao;
    }

    public void setIlanDao(IlanDAO ilanDao) {
        this.ilanDao = ilanDao;
    }

    public MusteriDAO getMusteriDao() {
        if(this.musteriDao == null) this.musteriDao = new MusteriDAO();
        return musteriDao;
    }

    public void setMusteriDao(MusteriDAO musteriDao) {
        this.musteriDao = musteriDao;
    }

    public void create(MusteriXilan c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES("
                    + c.getIlan().getIlan_id() + ", "
                    + c.getMusteri().getMusteri_id() + ", "
                    + c.isOdendi()
                    + ");";

            String query
                    = "insert into MUSTERIXILAN(ilan_id,musteri_id,odendi) " + values;
            int r = st.executeUpdate(query);

            System.out.println("DB INSERT returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void delete(MusteriXilan c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from musterixilan where alisveris_id=" + c.getAlisveris_id();
            int r = st.executeUpdate(query);
            
            System.out.println("DB DELETE returned with: " + r);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void update(MusteriXilan c){
        
        try{
            Statement st = this.getDb().createStatement();
            String query;
            query ="UPDATE MUSTERIXILAN " + "\n" +
                    "SET " + "\n"+
                    "ilan_id = " + c.getIlan().getIlan_id() + "," + "\n" +
                    "musteri_id = " + c.getMusteri().getMusteri_id() + "," + "\n" +
                    "odendi = " + c.isOdendi() + "\n" +
                    "WHERE alisveris_id = " + c.getAlisveris_id() + ";";

            int r = st.executeUpdate(query);

            System.out.println("DB UPDATE returned with: " + r);
            
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    
    }

    public List<MusteriXilan> getList() {
        List<MusteriXilan> musterixilanList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from musterixilan";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                musterixilanList.add(new MusteriXilan(
                        rs.getInt("alisveris_id"),
                        this.getIlanDao().findById( rs.getInt("ilan_id") ),
                        this.getMusteriDao().findById( rs.getInt("musteri_id") ),
                        rs.getBoolean("odendi")
                    )
                );
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return musterixilanList;
    }
    
    public List<MusteriXilan> getByMusteriId(int musteri_id) {
        List<MusteriXilan> musterixilanList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from musterixilan WHERE musteri_id = " + musteri_id;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                musterixilanList.add(new MusteriXilan(
                    rs.getInt("alisveris_id"),
                    this.getIlanDao().findById( rs.getInt("ilan_id") ),
                    this.getMusteriDao().findById( rs.getInt("musteri_id") ),
                    rs.getBoolean("odendi")
                    )
                );
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
