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
            String values = "VALUES("
                        + c.getKazanc_id() +","
                        + c.getAlisveris_id() + ", "+
                    "'" + c.getConfig() + "'" + ","
                        + c.isReferans() +
                    ");";

            String query =
                    "insert into KAZANC(kazanc_id,alisveris_id,config,referans) " + values;

            int r = st.executeUpdate(query);

            System.out.println("DB INSERT returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kazanc c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from kazanc where id=" + c.getKazanc_id();
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
                kazancList.add(new Kazanc(
                        rs.getInt("kazanc_id"),
                        rs.getInt("alisveris_id"),
                        rs.getString("config"),
                        rs.getBoolean("referans"),
                        rs.getTimestamp("created"),
                        rs.getTimestamp("updated")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kazancList;
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
