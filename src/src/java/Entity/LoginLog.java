/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Timestamp;



public class LoginLog {

    private int login_id;
    private String ip_addr;
    private Timestamp tarih;
    private int user_id;


    public LoginLog() {
    }

    public LoginLog(int login_id, String ip_addr, Timestamp tarih, int user_id) {
        this.login_id = login_id;
        this.ip_addr = ip_addr;
        this.tarih = tarih;
        this.user_id = user_id;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    public String getIp_addr() {
        return ip_addr;
    }

    public void setIp_addr(String ip_addr) {
        this.ip_addr = ip_addr;
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
        return "LoginLog{" + "login_id=" + login_id + ", ip_addr=" + ip_addr + ", tarih=" + tarih + ", user_id=" + user_id +'}';

    }

}
