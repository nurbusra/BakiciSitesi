package Entity;

import java.sql.Timestamp;

public class LoginLog {

    private int login_id;
    private Timestamp tarih;
    private int user_id;
    private Timestamp created;
    private Timestamp updated;

    public LoginLog() {
    }

    public LoginLog(Timestamp tarih, int user_id) {
        this.tarih = tarih;
        this.user_id = user_id;
    }

    public LoginLog(int login_id, Timestamp tarih, int user_id,Timestamp created,Timestamp updated) {
        this.login_id = login_id;
        this.tarih = tarih;
        this.user_id = user_id;
        this.created=created;
        this.updated=updated;
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
        return "LoginLog{" + "login_id=" + login_id + "user_id=" + user_id + '}';

    }

}
