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

            String query = "insert into superuser(created) values('" + c.getCreated() + "')";
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Superuser c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from bakici where id=" + c.getId();
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Superuser> getList() {
        List<Superuser> superuserList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from superuser";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                superuserList.add(new Superuser(rs.getInt("id"), rs.getTimestamp("created"), rs.getTimestamp("updated")));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return superuserList;
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
