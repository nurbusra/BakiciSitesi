package Entity;

import java.util.List;

public class Bakici extends User_ {

    private int bakici_id;
    private int neg_referans;
    private int poz_referans;
    private int gecmis_alisveris;
    
    private List<Ilan> ilanlarList;

    // Controller Sınıfının Kullanacağı Constructor
    public Bakici() {
    }

    // Veri Çekmek İçin Kullanılacak Constructor
    public Bakici(int user_id, String isim, String email, String sifre,
                    int sinif, int bakici_id, 
                    int neg_referans, int poz_referans, int gecmis_alisveris) {
        
        super(user_id, isim, email, sifre, sinif);
        this.bakici_id = bakici_id;
        this.neg_referans = neg_referans;
        this.poz_referans = poz_referans;
        this.gecmis_alisveris = gecmis_alisveris;    
    }
    
    // Oluşturma İşlemi İçin Kullanılacak Constructor
    public Bakici(String isim, String email, String sifre, int sinif) {
        super(isim, email, sifre, sinif);
    }

    public int getBakici_id() {
        return bakici_id;
    }

    public void setBakici_id(int bakici_id) {
        this.bakici_id = bakici_id;
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

    public List<Ilan> getIlanlarList() {
        return ilanlarList;
    }

    public void setIlanlarList(List<Ilan> ilanlarList) {
        this.ilanlarList = ilanlarList;
    }

    @Override
    public String toString() {
        return "Bakici{" + "user_id= " + this.getUser_id() + 
                " bakici_id= " + this.bakici_id + '}';
    }

}
