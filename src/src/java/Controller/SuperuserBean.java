/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.SuperuserDAO;
import Entity.Superuser;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "superuserBean")
@SessionScoped
public class SuperuserBean implements Serializable {

    private Superuser entity;
    private SuperuserDAO dao;
    private List<Superuser> list;
    
    public SuperuserBean() {
    }

    public Superuser getEntity() {
        if(this.entity == null) this.entity = new Superuser();
        return entity;
    }

    public void setEntity(Superuser entity) {
        this.entity = entity;
    }

    public SuperuserDAO getDao() {
        if(this.dao == null) this.dao = new SuperuserDAO();
        return dao;
    }

    public void setDao(SuperuserDAO dao) {
        this.dao = dao;
    }

    public List<Superuser> getList() {
        return this.getDao().getList();
    }

    public void setList(List<Superuser> list) {
        this.list = list;
    }
    
    public String createEntity() {
        this.getDao().create(this.entity);
        this.entity = new Superuser();
        return "/superuser.xhtml?faces-redirect=true";
    }
    
    public String deleteEntity() {
        this.getDao().delete(entity);
        this.entity = new Superuser();
        return "/superuser.xhtml?faces-redirect=true";
    }
    
    public String updateEntity() {
        this.getDao().update(this.entity);
        this.entity = new Superuser();
        return "/superuser.xhtml?faces-redirect=true";
    }
}