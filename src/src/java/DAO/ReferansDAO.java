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

    public void createReferans(Referans c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "insert into referans(created) values('" + c.getCreated() + "')";
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Referans c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from referans where id=" + c.getId();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Referans> getReferansList() {
        List<Referans> referansList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from referans";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                referansList.add(new Referans(rs.getInt("id"), rs.getInt("alisveris_id"), rs.getInt("deger"), rs.getTimestamp("created"), rs.getTimestamp("updated")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return referansList;
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
