package Entity;

public class Referans {

    private int ref_id;
    private int kazanc_id;
    private int deger;

    public Referans() {
    }

    public Referans(int kazanc_id, int deger) {
        this.kazanc_id = kazanc_id;
        this.deger = deger;
    }

    public Referans(int ref_id, int kazanc_id, int deger) {
        this.ref_id = ref_id;
        this.kazanc_id = kazanc_id;
        this.deger = deger;
    }

    public int getRef_id() {
        return ref_id;
    }

    public void setRef_id(int ref_id) {
        this.ref_id = ref_id;
    }

    public int getKazanc_id() {
        return kazanc_id;
    }

    public void setKazanc_id(int kazanc_id) {
        this.kazanc_id = kazanc_id;
    }

    public int getDeger() {
        return deger;
    }

    public void setDeger(int deger) {
        this.deger = deger;
    }

    @Override
    public String toString() {
        return "Referans{" + "ref_id=" + ref_id + ", kazanc_id=" + kazanc_id + '}';
    }

}
