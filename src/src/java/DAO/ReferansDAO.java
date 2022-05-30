package DAO;

import Entity.Referans;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReferansDAO extends DBConnection {

    private Connection db;

    public void create(Referans c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES("
                    + c.getRef_id() + ","
                    + c.getKazanc_id() + ","
                    + c.getDeger()
                    + ");";

            String query
                    = "insert into REFERANS(ref_id,kazanc_id,deger) " + values;
            int r = st.executeUpdate(query);

            System.out.println("DB INSERT returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Referans c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from referans where id=" + c.getRef_id();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Referans c) {
        try {
            Statement st = this.getDb().createStatement();

            String query;
            query = "UPDATE REFERANS" + "\n"
                    + "SET " + "\n"
                    + "deger = " + c.getDeger() + "\n"
                    + "WHERE ref_id = " + c.getRef_id() + ";";
            int r = st.executeUpdate(query);

            System.out.println("DB UPDATE returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Referans> getList() {
        List<Referans> referansList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from referans";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                referansList.add(new Referans(
                        rs.getInt("ref_id"),
                        rs.getInt("kazanc_id"),
                        rs.getInt("deger"),
                        rs.getTimestamp("created"),
                        rs.getTimestamp("updated")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return referansList;
    }

    public Referans findById(int id) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from Referans where ref_id=";
            query = query + String.valueOf(id);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                return (new Referans(
                        rs.getInt("ref_id"),
                        rs.getInt("kazanc_id"),
                        rs.getInt("deger"),
                        rs.getTimestamp("created"),
                        rs.getTimestamp("updated")));

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
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
