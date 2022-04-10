/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

public class MusteriXilan {

    private int alisveris_id;
    private int ilan_id;
    private int musteri_id;
    private boolean odendi;

    public MusteriXilan() {
    }

    public MusteriXilan(int ilan_id, int musteri_id) {
        this.ilan_id = ilan_id;
        this.musteri_id = musteri_id;
    }

    public MusteriXilan(int alisveris_id, int ilan_id, int musteri_id, boolean odendi) {
        this.alisveris_id = alisveris_id;
        this.ilan_id = ilan_id;
        this.musteri_id = musteri_id;
        this.odendi = odendi;
    }

    public int getAlisveris_id() {
        return alisveris_id;
    }

    public void setAlisveris_id(int alisveris_id) {
        this.alisveris_id = alisveris_id;
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

    @Override
    public String toString() {
        return "MusteriXilan{" + "alisveris_id=" + alisveris_id + ", ilan_id=" + ilan_id + ", musteri_id=" + musteri_id +'}';

    }

}
