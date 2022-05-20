package Entity;

import java.sql.Timestamp;


public class Musteri extends User_ {

    private int musteri_id, gecmis_alisveris;
    private Timestamp created;
    private Timestamp updated;

    // Constructor for controller class
    public Musteri() {
    }
    
    // Constructor for retrieving
    public Musteri(int user_id, String isim, String email, String sifre,
                    int sinif, int musteri_id, int gecmis_alisveris,Timestamp created,Timestamp updated) {
        
        super(user_id, isim, email, sifre, sinif);
        
        this.musteri_id = musteri_id;
        this.gecmis_alisveris = gecmis_alisveris;
        this.created=created;
        this.updated=updated;
    }
    
    // Constructor for creating
    public Musteri(String isim, String email, String sifre, int sinif) {
        super(isim, email, sifre, sinif);
    }
    
    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusetri_id(int id) {
        this.musteri_id = id;
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
        return "Musteri{" + "user_id= " + this.getUser_id() + "musteri_id= " + musteri_id + '}';

    }
}
