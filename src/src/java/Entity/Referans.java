package Entity;

import java.sql.Timestamp;

public class Referans {

    private int id;
    private int alisveris_id;
    private int deger;
    private Timestamp created;
    private Timestamp updated;

    public Referans() {
    }

    public Referans(int id, int alisveris_id, int deger, Timestamp created, Timestamp updated) {
        this.id = id;
        this.alisveris_id = alisveris_id;
        this.deger = deger;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlisveris_id() {
        return alisveris_id;
    }

    public void setAlisveris_id(int alisveris_id) {
        this.alisveris_id = alisveris_id;
    }

    public int getDeger() {
        return deger;
    }

    public void setDeger(int deger) {
        this.deger = deger;
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
        return "Referans{" + "id=" + id + ", alisveri_id=" + alisveris_id + ", deger=" + deger + ",created= " + created + ",updated= " + updated+'}';
    }

}
