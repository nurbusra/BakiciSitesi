package Entity;

public class User_ {

    private int id;
    private String isim;
    private String email;
    private String sifre;
    private int sinif;

    // Constructor for the controller class
    public User_() {
    }

    // Constructor for login action
    public User_(String email, String sifre) {
        this.email = email;
        this.sifre = sifre;
    }

    // Constructor for retrieving
    public User_(int id, String isim, String email, String sifre, int sinif) {
        this.id = id;
        this.isim = isim;
        this.email = email;
        this.sifre = sifre;
        this.sinif = sinif;
    }
    
    // Constructor for creating
//    public User_(String isim, String email, String sifre, int sinif) {
//        this.isim = isim;
//        this.email = email;
//        this.sifre = sifre;
//        this.sinif = sinif;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getSinif() {
        return sinif;
    }

    public void setSinif(int sinif) {
        this.sinif = sinif;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", isim=" + this.isim + 
                ", e_mail=" + this.email + ", sinif=" + this.sinif + '}';
    }
    
}
