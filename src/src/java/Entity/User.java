package Entity;

public class User {

    private int id;
    private String isim;
    private String e_mail;
    private String sifre;
    private int sinif;

    public User(String e_mail, String sifre) {
        this.e_mail = e_mail;
        this.sifre = sifre;
    }

    public User(int id, String isim, String e_mail, String sifre, int sinif) {
        this.id = id;
        this.isim = isim;
        this.e_mail = e_mail;
        this.sifre = sifre;
        this.sinif = sinif;
    }

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

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
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
        return "User{" + "id=" + id + ", isim=" + isim + ", e_mail=" + e_mail + ", sifre=" + sifre +", sinif="+ sinif + '}';

    }

}
