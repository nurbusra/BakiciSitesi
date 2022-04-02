/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Kazanc;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KazancDAO extends DBConnection {

    private Connection db;

    public void create(Kazanc c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "insert into kazanc(created) values('" + c.getCreated() + "')";
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kazanc c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from kazanc where id=" + c.getId();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Kazanc> getList() {
        List<Kazanc> kazancList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from kazanc";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                kazancList.add(new Kazanc(rs.getInt("id"), rs.getInt("alisveris_id"), rs.getString("config"), rs.getBoolean("referans"), rs.getTimestamp("created"), rs.getTimestamp("updated")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kazancList;
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
