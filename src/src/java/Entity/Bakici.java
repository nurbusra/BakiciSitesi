package Entity;

public class Bakici {

    private int id;
    private int neg_referans;
    private int poz_referans;
    private int gecmis_alisveris;

    public Bakici(int id, int neg_referans, int poz_referans, int gecmis_alisveris) {
        this.id = id;
        this.gecmis_alisveris = gecmis_alisveris;
        this.neg_referans = neg_referans;
        this.poz_referans = poz_referans;
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

    @Override
    public String toString() {
        return "Bakici{" + "id=" + id + ", gecmis_alisveris=" + gecmis_alisveris + ", poz_referans=" + poz_referans + ", neg_referans=" + neg_referans + '}';

    }

}
