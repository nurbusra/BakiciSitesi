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
    private Superuser setEntity;
    private Superuser Entity;
    
    private int page=1;
    private int pageCount; 
            
            
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

    public void previous(){
       page--;
       if (page < 1) {
           page = this.getPageCount();
       }
    }
    
    public void next(){
       page++;
       if (page > this.getPageCount() ){
           page = 1;
       }
    }
    
    public List<Superuser> getList() {
        return this.getDao().getList(page);
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
    
    public void clearEntity() {
        this.entity = new Superuser();
    }

    public Superuser getSetEntity() {
        return setEntity;
    }

    public void setSetEntity(Superuser setEntity) {
        this.setEntity = setEntity;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<Superuser> glist = this.getDao().getList();
        int size = glist.size();
        int pageCount = (int) Math.ceil(size/1);
                
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
        
}
  