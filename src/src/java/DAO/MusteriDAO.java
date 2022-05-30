/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Ilan;
import Entity.Musteri;
import Entity.MusteriXilan;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusteriDAO extends DBConnection {

    private Connection db;
    private MusteriXilanDAO miDao;
    private IlanDAO ilanDao;

    public void create(Musteri c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES("
                    + "'" + c.getIsim() + "'" + ", "
                    + "'" + c.getEmail() + "'" + ", "
                    + "'" + c.getSifre() + "'" + ", "
                    + c.getSinif()
                    + ");";

            String query
                    = "insert into MUSTERI(isim, email, sifre, sinif) " + values;

            int r = st.executeUpdate(query);

            System.out.println("DB INSERT returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Musteri c) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "delete from MUSTERI where musteri_id=" + c.getUser_id();
            int r = st.executeUpdate(query);

            System.out.println("DB DELETE returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Musteri c) {
        try {
            Statement st = this.getDb().createStatement();

            String query;
            query = "UPDATE MUSTERİ " + "\n"
                    + "SET " + "\n"
                    + "isim = " + "'" + c.getIsim() + "'" + ",\n"
                    + "email = " + "'" + c.getEmail() + "'" + ",\n"
                    + "sifre = " + "'" + c.getSifre() + "'" + "\n"
                    + "WHERE musteri_id = " + c.getMusteri_id() + ";";
            int r = st.executeUpdate(query);

            System.out.println("DB UPDATE returned with: " + r);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Musteri> getList() {
        List<Musteri> musteriList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from MUSTERI";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                musteriList.add(new Musteri(
                        rs.getInt("user_id"),
                        rs.getString("isim"),
                        rs.getString("email"),
                        rs.getString("sifre"),
                        rs.getInt("sinif"),
                        rs.getInt("musteri_id"),
                        rs.getInt("gecmis_alisveris")
                    )
                );
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return musteriList;
    }
    
    public Musteri findById (int id){
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from MUSTERI where musteri_id=";
            query=query+String.valueOf(id);
            
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                return (new Musteri(
                    rs.getInt("user_id"),
                    rs.getString("isim"),
                    rs.getString("email"),
                    rs.getString("sifre"),
                    rs.getInt("sinif"),
                    rs.getInt("musteri_id"),
                    rs.getInt("gecmis_alisveris")
                    )
                );
            }
        
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
            
        return null;
    }
    
    public Musteri findByUser_id (int id){
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from MUSTERI where user_id=";
            query=query+String.valueOf(id);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                return (new Musteri(
                    rs.getInt("user_id"),
                    rs.getString("isim"),
                    rs.getString("email"),
                    rs.getString("sifre"),
                    rs.getInt("sinif"),
                    rs.getInt("musteri_id"),
                    rs.getInt("gecmis_alisveris")
                    )
                );
            }
        
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
            
        return null;
    }
       
    private void retBasvuruList(Musteri entity) {
        List<MusteriXilan> temp = this.getMiDao().getByMusteriId(entity.getMusteri_id());
        
        entity.getBasvuruList().clear();
        
        for(MusteriXilan i: temp) {
            i = (MusteriXilan) i;
            // Detaylı görünümü ilan tablosundan çek
            Ilan il = this.getIlanDao().findById(i.getIlan().getIlan_id());
            entity.getBasvuruList().add(il);
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
    
    public MusteriXilanDAO getMiDao() {
        if(miDao == null) miDao = new MusteriXilanDAO();
        return miDao;
    }

    public void setMiDao(MusteriXilanDAO miDao) {
        this.miDao = miDao;
    }
    
    public IlanDAO getIlanDao() {
        if(ilanDao == null) ilanDao = new IlanDAO();
        return ilanDao;
    }

    public void setIlanDao(IlanDAO ilanDao) {
        this.ilanDao = ilanDao;
    }
}
