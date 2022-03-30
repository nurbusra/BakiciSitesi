package DAO;

import Entity.Bakici;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class BakiciDAO extends DBConnection {

    private Connection db;

    public void createBakici(Bakici c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "insert into bakici(created) values('" + c.getCreated() + "')";
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Bakici c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from bakici where id=" + c.getId();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Bakici> getBakiciList() {
        List<Bakici> bakiciList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from bakici";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                bakiciList.add(new Bakici(rs.getInt("id"), rs.getInt("neg_referans"), rs.getInt("poz_referans"), rs.getInt("gecmis_alisveris"), rs.getTimestamp("created"), rs.getTimestamp("updated")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return bakiciList;
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
