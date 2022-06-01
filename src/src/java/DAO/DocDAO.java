/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Doc;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Merve
 */
public class DocDAO extends DBConnection {

    private Connection db;

    public void create(Doc c) {
        try {
            Statement st = this.getDb().createStatement();
            String values = "VALUES("
                    + "'" + c.getDoc_path()+ "'"
                    + ");";

            String query
                    = "insert into DOC(doc_path) " + values;

            System.out.println(query);
            int r = st.executeUpdate(query);

            System.out.println("DB INSERT returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void delete(Doc c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from DOC where doc_id=" + c.getDoc_id();
            int r = st.executeUpdate(query);
            System.out.println("DB DELETE returned with: " + r);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void update(Doc c) {

        try {
            Statement st = this.getDb().createStatement();

            String query;
            query = "UPDATE DOC " + "\n"
                    + "SET " + "\n"
                    + "doc_path = " + c.getDoc_path() + "\n" 
                    + "WHERE doc_id = " + c.getDoc_id() + ";";
            System.out.println(query);
            int r = st.executeUpdate(query);

            System.out.println("DB UPDATE returned with: " + r);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }

    public List<Doc> getList() {
        List<Doc> loginlogList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from DOC";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                loginlogList.add(new Doc(
                        rs.getInt("doc_id"),
                        rs.getString("doc_path")
                    )
                );
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return loginlogList;
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
