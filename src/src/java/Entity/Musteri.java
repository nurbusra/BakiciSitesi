package Entity;

import DAO.MusteriXilanDAO;
import java.util.List;


public class Musteri extends User_ {

    private int musteri_id, gecmis_alisveris;
    
    //-------- To be set later
    private List<MusteriXilan> basvuruList;
    //--------
    
    private MusteriXilanDAO miDao;

    // Constructor for controller class
    public Musteri() {
    }
    
    // Constructor for retrieving
    public Musteri(int user_id, String isim, String email, String sifre,
                    int sinif, int musteri_id, int gecmis_alisveris) {
        
        super(user_id, isim, email, sifre, sinif);
        
        this.musteri_id = musteri_id;
        this.gecmis_alisveris = gecmis_alisveris;
    }
    
    // Constructor for creating
    public Musteri(String isim, String email, String sifre, int sinif) {
        super(isim, email, sifre, sinif);
    }
    
    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int id) {
        this.musteri_id = id;
    }

    public int getGecmis_alisveris() {
        return gecmis_alisveris;
    }

    public void setGecmis_alisveris(int gecmis_alisveris) {
        this.gecmis_alisveris = gecmis_alisveris;
    }

    public List<MusteriXilan> getBasvuruList() {
        return basvuruList;
    }

    public void setBasvuruList(List<MusteriXilan> basvuruList) {
        this.basvuruList = basvuruList;
    }
    
    public void updateBasvuruList(int id) {
        this.setBasvuruList( this.getMiDao().getByMusteriId(musteri_id) );
    }

    public MusteriXilanDAO getMiDao() {
        if(miDao == null) miDao = new MusteriXilanDAO();
        return miDao;
    }

    public void setMiDao(MusteriXilanDAO miDao) {
        if(miDao == null) miDao = new MusteriXilanDAO();
        this.miDao = miDao;
    }
    
    public boolean checkBasvuru(int musteri_id, int ilan_id) {
        return this.getMiDao().checkBasvuru(musteri_id, ilan_id);
    }

    @Override
    public String toString() {
        return "Musteri{" + "user_id= " + this.getUser_id() + "musteri_id= " + musteri_id + '}';

    }
}
