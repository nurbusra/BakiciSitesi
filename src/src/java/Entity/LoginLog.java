package Entity;

import java.sql.Timestamp;

public class LoginLog {

    private int login_id; //DEFAULT
    private int user_id;
    private Timestamp tarih; //DEFAULT
    private String ip_addr;

    //Controller
    public LoginLog() {
    }

    //Create
    public LoginLog(int user_id, String ip_addr) {
        this.user_id = user_id;
        this.ip_addr = ip_addr;
    }

    //Retrieve
    public LoginLog(int login_id, int user_id, Timestamp tarih, String ip_addr)  {
        this.login_id = login_id;
        this.user_id = user_id;
        this.tarih = tarih;
        this.ip_addr = ip_addr;
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

    public String getIp_addr() {
        return ip_addr;
    }

    public void setIp_addr(String ip_addr) {
        this.ip_addr = ip_addr;
    }

    @Override
    public String toString() {
        return "LoginLog{" + "login_id=" + login_id + "user_id=" + user_id + '}';

    }

}
