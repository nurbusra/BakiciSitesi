/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Musteri;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusteriDAO extends DBConnection {

    private Connection db;

    public void create(Musteri c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES(" + 
                    "'" + c.getIsim() + "'" + ", " +
                    "'" + c.getEmail() + "'" + ", " +
                    "'" + c.getSifre() + "'" + ", " +
                    c.getSinif() + 
                    ");";
            
            String query = 
                    "insert into MUSTERI(isim, email, sifre, sinif) " + values;
                            
            int r = st.executeUpdate(query);
            
            System.out.println("DB INSERT returned with: " + r);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Musteri c) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "delete from MUSTERI where id=" + c.getUser_id();          
            int r = st.executeUpdate(query);
            
            System.out.println("DB DELETE returned with: " + r);
            
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
                musteriList.add( new Musteri(
                        rs.getInt("id"),
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
