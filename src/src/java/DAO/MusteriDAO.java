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

            String query = "insert into musteri(created) values('" + c.getCreated() + "')";
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Musteri c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from musteri where id=" + c.getId();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Musteri> getList() {
        List<Musteri> musteriList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from musteri";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                musteriList.add(new Musteri(rs.getInt("id"), rs.getInt("gecmis_alisveris"), rs.getTimestamp("created"), rs.getTimestamp("updated")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return musteriList;
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
