/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.MusteriDAO;
import Entity.Musteri;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "musteriBean")
@SessionScoped
public class MusteriBean implements Serializable {
    
    private Musteri entity;
    private MusteriDAO dao;
    private List<Musteri> list;
    
    public MusteriBean() {
    }

    public Musteri getEntity() {
        if(entity == null) entity = new Musteri();
        return entity;
    }

    public void setEntity(Musteri entity) {
        this.entity = entity;
    }

    public MusteriDAO getDao() {
        if(dao == null) dao = new MusteriDAO();
        return dao;
    }

    public void setDao(MusteriDAO dao) {
        this.dao = dao;
    }

    public List<Musteri> getList() {
        return this.getDao().getList();
    }

    public void setList(List<Musteri> list) {
        this.list = list;
    }
    
    public void createEntity() {
        this.getDao().create(this.entity);
        this.entity = new Musteri();
    }
    
    public void deleteEntity() {
        this.getDao().delete(entity);
        this.entity = new Musteri();
    }
    
    public void updateEntity() {
        this.getDao().update(this.entity);
        this.entity = new Musteri();
    }
}
