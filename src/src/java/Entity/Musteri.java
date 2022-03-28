
package Entity;

public class Musteri {
    private int id;
    private int gecmis_alisveris;

    public Musteri(int id, int gecmis_alisveris) {
        this.id = id;
        this.gecmis_alisveris = gecmis_alisveris;
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
 public String toString() {
        return "Musteri{" + "id=" + id + ", gecmis_alisveris=" + gecmis_alisveris + '}';

    }   
}
