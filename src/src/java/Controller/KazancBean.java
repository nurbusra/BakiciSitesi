/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.KazancDAO;
import Entity.Kazanc;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "kazancBean")
@SessionScoped
public class KazancBean implements Serializable {

    private KazancDAO dao;
    private Kazanc entity;
    private List<Kazanc> list;
    
    public KazancBean() {
    }
    
    public KazancDAO getDao() {
        if(this.dao == null) this.dao = new KazancDAO();
        return dao;
    }

    public void setDao(KazancDAO dao) {
        this.dao = dao;
    }

    public Kazanc getEntity() {
        if(this.entity == null) this.entity = new Kazanc();
        return entity;
    }

    public void setEntity(Kazanc entity) {
        this.entity = entity;
    }

    public List<Kazanc> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kazanc> list) {
        this.list = list;
    }
    
    public String createEntity() {
        this.getDao().create(this.entity);
        this.entity = new Kazanc();
        return "";
    }
    
    public String deleteEntity() {
        this.getDao().delete(entity);
        this.entity = new Kazanc();
        return "";
    }
}
