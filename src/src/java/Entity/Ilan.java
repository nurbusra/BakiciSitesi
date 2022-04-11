/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

public class Ilan {

    private int ilan_id;
    private Bakici bakici;
    private String aciklama;
    private boolean aktif;
    private float ucret;

    // Controller Sınıfının Kullanacağı Constructor
    public Ilan() {
    }

    public Ilan(Bakici bakici, String aciklama, float ucret) {
        this.bakici = bakici;
        this.aciklama = aciklama;
        this.ucret = ucret;
    }

    // Veri Çekmek İçin Kullanılacak Constructor
    public Ilan(int ilan_id, Bakici bakici, String aciklama, boolean aktif, float ucret) {
        this.ilan_id = ilan_id;
        this.bakici = bakici;
        this.aciklama = aciklama;
        this.aktif = aktif;
        this.ucret = ucret;

    }

    public int getIlan_id() {
        return ilan_id;
    }

    public void setIlan_id(int ilan_id) {
        this.ilan_id = ilan_id;
    }

    public Bakici getBakici() {
        return bakici;
    }

    public void setBakici(Bakici bakici) {
        this.bakici = bakici;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }
    
    public boolean getAktif() {
        return this.aktif;
    }

    public float getUcret() {
        return ucret;
    }

    public void setUcret(float ucret) {
        this.ucret = ucret;
    }

    @Override
    public String toString() {
        return "Ilan{" + "ilan_id=" + ilan_id + ", bakici_id=" + bakici + '}';

    }

}
