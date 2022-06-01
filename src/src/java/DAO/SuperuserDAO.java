package DAO;

import Entity.Superuser;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SuperuserDAO extends DBConnection {

    private Connection db;

    public void create(Superuser c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES(" + 
                    "'" + c.getIsim() + "'" + ", " +
                    "'" + c.getEmail() + "'" + ", " +
                    "'" + c.getSifre() + "'" + ", " +
                          c.getSinif() + 
                    ");";
            
            String query = 
                    "insert into SUPERUSER(isim, email, sifre, sinif) " + values;
                            
            int r = st.executeUpdate(query);
            
            System.out.println("DB INSERT returned with: " + r);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void delete(Superuser c) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "delete from SUPERUSER where su_id=" + c.getSu_id();          
            int r = st.executeUpdate(query);
            
            System.out.println("DB DELETE returned with: " + r);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void update(Superuser c) {
        try {
            Statement st = this.getDb().createStatement();

            String query;
            query = "UPDATE SUPERUSER" + "\n"
                    + "SET " + "\n"
                    + "isim = " + "'" + c.getIsim() + "'" + ",\n"
                    + "email = " + "'" + c.getEmail() + "'" + ",\n"
                    + "sifre = " + "'" + c.getSifre() + "'" + "\n"
                    + "WHERE su_id = " + c.getSu_id() + ";";
            int r = st.executeUpdate(query);

            System.out.println("DB UPDATE returned with: " + r);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Superuser> getList() {
        List<Superuser> superuserList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from SUPERUSER";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                superuserList.add( new Superuser(
                        rs.getInt("user_id"),
                        rs.getString("isim"),
                        rs.getString("email"), 
                        rs.getString("sifre"),
                        rs.getInt("sinif"),
                        rs.getInt("su_id")
                    )
                );
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return superuserList;
    }
    
    public Superuser findById (int id){
        try {
        Statement st = this.getDb().createStatement();

        String query = "select * from SUPERUSER where su_id=";
        query=query+String.valueOf(id);
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
                return (new Superuser(
                    rs.getInt("user_id"),
                    rs.getString("isim"),
                    rs.getString("email"),
                    rs.getString("sifre"),
                    rs.getInt("sinif"),
                    rs.getInt("su_id")
                    )
                );
            }
        
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
            
        return null;
    }
    
    public Superuser findByUser_id (int id){
        try {
        Statement st = this.getDb().createStatement();

        String query = "select * from SUPERUSER where user_id=";
        query=query+String.valueOf(id);
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
                return (new Superuser(
                    rs.getInt("user_id"),
                    rs.getString("isim"),
                    rs.getString("email"),
                    rs.getString("sifre"),
                    rs.getInt("sinif"),
                    rs.getInt("su_id")
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

    public void clear(Superuser entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
