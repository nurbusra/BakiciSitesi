package Entity;


public class Referans {

    private int ref_id;
    private int alisveris_id;
    private int deger;

    public Referans() {
    }

    public Referans(int ref_id, int alisveris_id, int deger) {
        this.ref_id = ref_id;
        this.alisveris_id = alisveris_id;
        this.deger = deger;
    }

    public int getRef_id() {
        return ref_id;
    }

    public void setRef_id(int ref_id) {
        this.ref_id = ref_id;
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

    @Override
    public String toString() {
        return "Referans{" + "ref_id=" + ref_id + ", alisveri_id=" + alisveris_id + ", deger=" + deger +'}';
    }

}
