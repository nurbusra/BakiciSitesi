/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Timestamp;

public class Ilan {

    private int id;
    private int bakici_id;
    private String aciklama;
    private boolean aktif;
    private float ucret;
    private Timestamp created;
    private Timestamp updated;

    public Ilan() {
    }

    public Ilan(int id, int bakici_id, String aciklama, boolean aktif, float ucret, Timestamp created, Timestamp updated) {
        this.id = id;
        this.bakici_id = bakici_id;
        this.aciklama = aciklama;
        this.aktif = aktif;
        this.ucret = ucret;
        this.created = created;
        this.updated = updated;
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
        return "Ilan{" + "id=" + id + ", bakici_id=" + bakici_id + ", aciklama=" + aciklama + ", aktif=" + aktif + ", ucret=" + ucret + ",created= " + created + ",updated= " + updated+'}';

    }

}
