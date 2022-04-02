package Entity;

import java.sql.Timestamp;

public class Kazanc {

    private int id;
    private int alisveris_id;
    private String config;
    private boolean referans;
    private Timestamp created;
    private Timestamp updated;

    public Kazanc() {
    }

    public Kazanc(int id, int alisveris_id, String config, boolean referans, Timestamp created, Timestamp updated) {
        this.id = id;
        this.alisveris_id = alisveris_id;
        this.config = config;
        this.referans = referans;
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

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
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

    public boolean isReferans() {
        return referans;
    }

    public void setReferans(boolean referans) {
        this.referans = referans;
    }

    @Override
    public String toString() {
        return "Kazanc{" + "id=" + id + ", alisveri_id=" + alisveris_id + ", config=" + config + ", referans=" +referans+ ",created= " + created + ",updated= " + updated + '}';
    }

}
