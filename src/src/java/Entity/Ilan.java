/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

public class Ilan {

    private int ilan_id;
    private int bakici_id;
    private String aciklama;
    private boolean aktif;
    private float ucret;

    // Controller Sınıfının Kullanacağı Constructor
    public Ilan() {
    }

    public Ilan(int bakici_id, String aciklama, float ucret) {
        this.bakici_id = bakici_id;
        this.aciklama = aciklama;
        this.ucret = ucret;
    }

    // Veri Çekmek İçin Kullanılacak Constructor
    public Ilan(int ilan_id, int bakici_id, String aciklama, boolean aktif, float ucret) {
        this.ilan_id = ilan_id;
        this.bakici_id = bakici_id;
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

    public int getBakici_id() {
        return bakici_id;
    }

    public void setBakici_id(int bakici_id) {
        this.bakici_id = bakici_id;
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
        return "Ilan{" + "ilan_id=" + ilan_id + ", bakici_id=" + bakici_id + '}';

    }

}
