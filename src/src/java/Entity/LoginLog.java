/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Timestamp;


public class LoginLog {
    private int id;
    private String ip_addr;
    private Timestamp tarih;
    private int user_id;

    public LoginLog(int id, String ip_addr, Timestamp tarih, int user_id) {
        this.id = id;
        this.ip_addr = ip_addr;
        this.tarih = tarih;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "LoginLog{" + "id=" + id + ", ip_addr=" + ip_addr + ", tarih=" + tarih + ", user_id=" + user_id + '}';

    }
    
}
