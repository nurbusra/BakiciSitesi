package DAO;

import Entity.Bakici;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BakiciDAO extends DBConnection {

    private Connection db;

    public void create(Bakici c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES("
                    + "'" + c.getIsim() + "'" + ", "
                    + "'" + c.getEmail() + "'" + ", "
                    + "'" + c.getSifre() + "'" + ", "
                    + c.getSinif()
                    + ");";

            String query
                    = "insert into BAKICI(isim, email, sifre, sinif) " + values;

            int r = st.executeUpdate(query);

            System.out.println("DB INSERT returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Bakici c) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "delete from BAKICI where bakici_id=" + c.getUser_id();
            int r = st.executeUpdate(query);

            System.out.println("DB DELETE returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Bakici c) {
        try {
            Statement st = this.getDb().createStatement();

            String query;
            query = "UPDATE BAKICI " + "\n"
                    + "SET " + "\n"
                    + "isim = " + "'" + c.getIsim() + "'" + ",\n"
                    + "email = " + "'" + c.getEmail() + "'" + ",\n"
                    + "sifre = " + "'" + c.getSifre() + "'" + "\n"
                    + "WHERE bakici_id = " + c.getBakici_id() + ";";
            int r = st.executeUpdate(query);

            System.out.println("DB UPDATE returned with: " + r);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Bakici> getList() {
        List<Bakici> bakiciList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from BAKICI";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                bakiciList.add(new Bakici(
                        rs.getInt("user_id"),
                        rs.getString("isim"),
                        rs.getString("email"),
                        rs.getString("sifre"),
                        rs.getInt("sinif"),
                        rs.getInt("bakici_id"),
                        rs.getInt("neg_referans"),
                        rs.getInt("poz_referans"),
                        rs.getInt("gecmis_alisveris"),
                        rs.getTimestamp("created"),
                        rs.getTimestamp("updated")
                        )
                );
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return bakiciList;
    }
    public Bakici findById (int id){
        try {
        Statement st = this.getDb().createStatement();

        String query = "select * from BAKICI where bakici_id=";
        query=query+String.valueOf(id);
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
                return (new Bakici(
                        rs.getInt("user_id"),
                        rs.getString("isim"),
                        rs.getString("email"),
                        rs.getString("sifre"),
                        rs.getInt("sinif"),
                        rs.getInt("bakici_id"),
                        rs.getInt("neg_referans"),
                        rs.getInt("poz_referans"),
                        rs.getInt("gecmis_alisveris"),
                        rs.getTimestamp("created"),
                        rs.getTimestamp("updated")
                )
                );
            }
        
        }catch (Exception e){
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
