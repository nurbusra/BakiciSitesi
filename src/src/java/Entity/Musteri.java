package Entity;

import java.sql.Timestamp;

public class Musteri {

    private int id;
    private int gecmis_alisveris;
    private Timestamp created;
    private Timestamp updated;

    public Musteri() {
    }

    public Musteri(int id, int gecmis_alisveris, Timestamp created, Timestamp updated) {
        this.id = id;
        this.gecmis_alisveris = gecmis_alisveris;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGecmis_alisveris() {
        return gecmis_alisveris;
    }

    public void setGecmis_alisveris(int gecmis_alisveris) {
        this.gecmis_alisveris = gecmis_alisveris;
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

    public String toString() {
        return "Musteri{" + "id=" + id + ", gecmis_alisveris=" + gecmis_alisveris + ",created= " + created + ",updated= " + '}';

    }
}
