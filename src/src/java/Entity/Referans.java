
package Entity;

public class Referans {
    private int id;
    private int alisveris_id;
    private int deger;
    
    public Referans(int id, int alisveris_id, int deger) {
        this.id = id;
        this.alisveris_id = alisveris_id;
        this.deger = deger;
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
    @Override
     public String toString() {
        return "Referans{" + "id=" + id + ", alisveri_id=" + alisveris_id + ", deger=" + deger + '}';
    }
    
}
