package Entity;

import java.sql.Timestamp;

public class SuperUser {

    private int id;
    private Timestamp created;
    private Timestamp updated;

    public SuperUser() {
    }

    public SuperUser(int id, Timestamp created, Timestamp updated) {
        this.id = id;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "SuperUser{" + "id=" + id + ",created= " + created + ",updated= " + '}';
    }
}
