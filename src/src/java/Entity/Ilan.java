/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


public class Ilan {
    private int id;
    private int bakici_id;
    private String aciklama;
    private boolean aktif;
    private float ucret ;

    public Ilan(int id, int bakici_id, String aciklama, boolean aktif, float ucret) {
        this.id = id;
        this.bakici_id = bakici_id;
        this.aciklama = aciklama;
        this.aktif = aktif;
        this.ucret = ucret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getUcret() {
        return ucret;
    }

    public void setUcret(float ucret) {
        this.ucret = ucret;
    }
    @Override
    public String toString() {
        return "Ilan{" + "id=" + id + ", bakici_id=" + bakici_id + ", aciklama=" + aciklama + ", aktif=" + aktif+", ucret="+ ucret + '}';

    }
    
}
