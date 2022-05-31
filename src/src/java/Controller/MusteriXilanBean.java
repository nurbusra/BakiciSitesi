/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.IlanDAO;
import DAO.MusteriXilanDAO;
import Entity.MusteriXilan;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "musterixilanBean")
@SessionScoped
public class MusteriXilanBean implements Serializable {

    private MusteriXilanDAO dao;
    private MusteriXilan entity;
    private List<MusteriXilan> list;
    
    private IlanDAO ilanDao;
    
    public MusteriXilanBean() {
    }

    public MusteriXilanDAO getDao() {
        if(dao == null) dao = new MusteriXilanDAO();
        return dao;
    }

    public void setDao(MusteriXilanDAO dao) {
        this.dao = dao;
    }

    public MusteriXilan getEntity() {
        if(entity == null) entity = new MusteriXilan();
        return entity;
    }

    public void setEntity(MusteriXilan entity) {
        this.entity = entity;
    }

    public List<MusteriXilan> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<MusteriXilan> list) {
        this.list = list;
    }

    public IlanDAO getIlanDao() {
        if(ilanDao == null) ilanDao = new IlanDAO();
        return ilanDao;
    }

    public void setIlanDao(IlanDAO ilanDao) {
        this.ilanDao = ilanDao;
    }

    public void createEntity() {
        System.out.println("Musteri ID: " + entity.getMusteri().getMusteri_id());
        System.out.println("Ilan ID: " + entity.getIlan().getIlan_id());
        this.getDao().create(entity);
        this.entity = new MusteriXilan();
    }
    
    public void deleteEntity() {
        this.getDao().delete(entity);
        this.entity = new MusteriXilan();
    }
    
    public void updateEntity() {
        this.getDao().update(entity);
        this.entity = new MusteriXilan();
    }
    
    public void clear() {
        this.entity = new MusteriXilan();
    }
    
    public void basvur(int musteri_id, int ilan_id) {
        this.setEntity(new MusteriXilan());
        
        this.getEntity().getIlan().setIlan_id(ilan_id);
        this.getEntity().getMusteri().setMusteri_id(musteri_id);
        this.getEntity().setOdendi(false);

        this.getDao().create(entity);
        this.setEntity(new MusteriXilan());
    }
}
