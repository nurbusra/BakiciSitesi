/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.BakiciDAO;
import DAO.MusteriDAO;
import Entity.Bakici;
import Entity.Musteri;
import Entity.User_;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "kayitBean")
@SessionScoped
public class KayitBean implements Serializable {

    private User_ entity;
    private BakiciDAO bakiciDao;
    private MusteriDAO musteriDao;
    
    public KayitBean() {
    }

    public User_ getEntity() {
        return entity;
    }

    public void setEntity(User_ entity) {
        if(this.entity == null) this.entity = new User_();
        this.entity = entity;
    }

    public BakiciDAO getBakiciDao() {
        if(this.bakiciDao == null) this.bakiciDao = new BakiciDAO();
        return bakiciDao;
    }

    public void setBakiciDao(BakiciDAO bakiciDao) {
        this.bakiciDao = bakiciDao;
    }

    public MusteriDAO getMusteriDao() {
        if(this.musteriDao == null) this.musteriDao = new MusteriDAO();
        return musteriDao;
    }

    public void setMusteriDao(MusteriDAO musteriDao) {
        this.musteriDao = musteriDao;
    }
    
    public String createEntity() {
        if(this.entity.getSinif() == 1) {
            // Musteri
            Musteri o = (Musteri) this.entity;
            this.getMusteriDao().create(o);
        }
        else if(this.entity.getSinif() == 2) {
            // Bakici
            Bakici o = (Bakici) this.entity;
            this.getBakiciDao().create(o);
        }
        this.entity = new User_();
        return "users.xhtml?faces-redirect=true";
    }
}
