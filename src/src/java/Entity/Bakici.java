package Entity;

import java.sql.Timestamp;

public class Bakici {

    private int id;
    private int neg_referans;
    private int poz_referans;
    private int gecmis_alisveris;
    private Timestamp created;
    private Timestamp updated;

    public Bakici() {
    }

    public Bakici(int id, int neg_referans, int poz_referans, int gecmis_alisveris, Timestamp created, Timestamp updated) {
        this.id = id;
        this.neg_referans = neg_referans;
        this.poz_referans = poz_referans;
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

    public int getNeg_referans() {
        return neg_referans;
    }

    public void setNeg_referans(int neg_referans) {
        this.neg_referans = neg_referans;
    }

    public int getPoz_referans() {
        return poz_referans;
    }

    public void setPoz_referans(int poz_referans) {
        this.poz_referans = poz_referans;
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

    @Override
    public String toString() {
        return "Bakici{" + "id=" + id + ", gecmis_alisveris=" + gecmis_alisveris + ", poz_referans=" + poz_referans + ", neg_referans=" + neg_referans + ",created= " + created + ",updated= " +updated+ '}';

    }

}
