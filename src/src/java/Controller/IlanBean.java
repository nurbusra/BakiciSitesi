/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.IlanDAO;
import Entity.Ilan;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "ilanBean")
@SessionScoped
public class IlanBean implements Serializable {

    private IlanDAO dao;
    private Ilan entity;
    private List<Ilan> list;

    public IlanDAO getDao() {
        if(this.dao == null) this.dao = new IlanDAO();
        return dao;
    }

    public void setDao(IlanDAO dao) {
        this.dao = dao;
    }

    public Ilan getEntity() {
        if(this.entity == null) this.entity = new Ilan();
        return entity;
    }

    public void setEntity(Ilan entity) {
        this.entity = entity;
    }

    public List<Ilan> getList() {
        this.list = this.getDao().getList();
        return this.list;
    }

    public void setList(List<Ilan> list) {
        this.list = list;
    }
    
    public String createEntity() {
        this.getDao().create(this.entity);
        this.entity = new Ilan();
        return "/ilanlar.xhtml?faces-redirect=true";
    }
    
    public void deleteEntity() {
        this.getDao().delete(entity);
        this.entity = new Ilan();
        //return "/ilanlar.xhtml?faces-redirect=true";
    }
    
    public String updateEntity() {
        this.getDao().update(this.entity);
        this.entity = new Ilan();
        return "/ilanlar.xhtml?faces-redirect=true";
    }
    
    public String redirectToIlanlar() {
        return "/ilanlar.xhtml";
    }
}
