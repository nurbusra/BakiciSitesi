/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Timestamp;

public class MusteriXilan {

    private int id;
    private int ilan_id;
    private int musteri_id;
    private boolean odendi;
    private Timestamp created;
    private Timestamp updated;

    public MusteriXilan() {
    }

    public MusteriXilan(int id, int ilan_id, int musteri_id, boolean odendi, Timestamp created, Timestamp updated) {
        this.id = id;
        this.ilan_id = ilan_id;
        this.musteri_id = musteri_id;
        this.odendi = odendi;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIlan_id() {
        return ilan_id;
    }

    public void setIlan_id(int ilan_id) {
        this.ilan_id = ilan_id;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public boolean isOdendi() {
        return odendi;
    }

    public void setOdendi(boolean odendi) {
        this.odendi = odendi;
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
        return "MusteriXilan{" + "id=" + id + ", ilan_id=" + ilan_id + ", musteri_id=" + musteri_id + ", odendi=" + odendi + ",created= " + created + ",updated= " + updated+'}';

    }

}
