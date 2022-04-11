/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

public class MusteriXilan {

    private int alisveris_id;
    private Ilan ilan;
    private Musteri musteri;
    private boolean odendi;

    public MusteriXilan() {
    }

    public MusteriXilan(Ilan ilan, Musteri musteri) {
        this.ilan = ilan;
        this.musteri = musteri;
    }

    public MusteriXilan(int alisveris_id, Ilan ilan, Musteri musteri, boolean odendi) {
        this.alisveris_id = alisveris_id;
        this.ilan = ilan;
        this.musteri = musteri;
        this.odendi = odendi;
    }

    public int getAlisveris_id() {
        return alisveris_id;
    }

    public void setAlisveris_id(int alisveris_id) {
        this.alisveris_id = alisveris_id;
    }

    public Ilan getIlan() {
        return ilan;
    }

    public void setIlan(Ilan ilan) {
        this.ilan = ilan;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public boolean isOdendi() {
        return odendi;
    }

    public void setOdendi(boolean odendi) {
        this.odendi = odendi;
    }

    @Override
    public String toString() {
        return "MusteriXilan{" + "alisveris_id=" + alisveris_id + ", ilan_id=" + ilan + ", musteri_id=" + musteri +'}';

    }

}
