/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.BakiciDAO;
import Entity.Bakici;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "bakiciBean")
@SessionScoped
public class BakiciBean implements Serializable {

    private Bakici entity;
    private BakiciDAO dao;
    private List<Bakici> list;
    
    public BakiciBean() {
    }

    public Bakici getEntity() {
        if(this.entity == null) this.entity = new Bakici();
        return entity;
    }

    public void setEntity(Bakici entity) {
        this.entity = entity;
    }

    public BakiciDAO getDao() {
        if(this.dao == null) this.dao = new BakiciDAO();
        return dao;
    }

    public void setDao(BakiciDAO dao) {
        this.dao = dao;
    }

    public List<Bakici> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Bakici> list) {
        this.list = list;
    }
    
    public void createEntity() {
        this.getDao().create(this.entity);
        this.entity = new Bakici();
        //return "/bakicilar.xhtml?faces-redirect=true";
    }
    
    public void deleteEntity() {
        this.getDao().delete(entity);
        this.entity = new Bakici();
        //return "/bakicilar.xhtml?faces-redirect=true";
    }
    
    public void updateEntity() {
        this.getDao().update(this.entity);
        this.entity = new Bakici();
        //return "/bakicilar.xhtml?faces-redirect=true";
    }
    
    public void clearEntity() {
        this.entity = new Bakici();
    }
}
