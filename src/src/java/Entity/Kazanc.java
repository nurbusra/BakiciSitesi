package Entity;

import java.sql.Timestamp;

public class Kazanc {

    private int kazanc_id;
    private int alisveris_id;
    private String config;
    private boolean referans;
    private Timestamp created;
    private Timestamp updated;

    public Kazanc() {
    }

    public Kazanc(int alisveris_id, String config) {
        this.alisveris_id = alisveris_id;
        this.config = config;
    }

    public Kazanc(int kazanc_id, int alisveris_id, String config, boolean referans,Timestamp created,Timestamp updated) {
        this.kazanc_id = kazanc_id;
        this.alisveris_id = alisveris_id;
        this.config = config;
        this.referans = referans;
        this.created=created;
        this.updated=updated;

    }

    public int getKazanc_id() {
        return kazanc_id;
    }

    public void setKazanc_id(int kazanc_id) {
        this.kazanc_id = kazanc_id;
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

    public boolean isReferans() {
        return referans;
    }

    public void setReferans(boolean referans) {
        this.referans = referans;
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
        return "Kazanc{" + "kazanc_id=" + kazanc_id + ", alisveri_id=" + alisveris_id + '}';
    }

}
