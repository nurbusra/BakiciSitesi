/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Timestamp;

public class LoginLog {

    private int login_id;
    private Timestamp tarih;
    private int user_id;

    public LoginLog() {
    }

    public LoginLog(Timestamp tarih, int user_id) {
        this.tarih = tarih;
        this.user_id = user_id;
    }

    public LoginLog(int login_id, Timestamp tarih, int user_id) {
        this.login_id = login_id;
        this.tarih = tarih;
        this.user_id = user_id;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }


    public Timestamp getTarih() {
        return tarih;
    }

    public void setTarih(Timestamp tarih) {
        this.tarih = tarih;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "LoginLog{" + "login_id=" + login_id + "user_id=" + user_id + '}';

    }

}
