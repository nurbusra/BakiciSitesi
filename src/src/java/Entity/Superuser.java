package Entity;


public class Superuser extends User_ {

    private int su_id;

    // Controller
    public Superuser() {
    }

    // Veri Çekme
    public Superuser(int user_id, String isim, String email, 
            String sifre, int sinif, int su_id) {
        
        super(user_id, isim, email, sifre, sinif);
        this.su_id = su_id;
    }
    
    // Oluşturma 
    public Superuser(String isim, String email, 
            String sifre, int sinif) {
        
        super(isim, email, sifre, sinif);
    }
    
    public int getSu_id() {
        return su_id;
    }

    public void setSu_id(int su_id) {
        this.su_id = su_id;
    }

    @Override
    public String toString() {
        return "Bakici{" + "user_id= " + this.getUser_id() + 
                " bakici_id= " + this.su_id + '}';
    }
}
