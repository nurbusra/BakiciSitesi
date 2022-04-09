/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import Entity.User_;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private UserDAO dao;
    private User_ entity;
    private List<User_> list;

    public List<User_> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<User_> list) {
        this.list = list;
    }
    
    public UserBean() {
    }

    public UserDAO getDao() {
        if (this.dao == null) this.dao = new UserDAO();
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public User_ getEntity() {
        if (this.entity == null) this.entity = new User_();
        return entity;
    }

    public void setEntity(User_ entity) {
        this.entity = entity;
    }
    
    public String createEntity() {
        this.getDao().create(entity);
        
        // Insert into the corresponding 
        // inheriting table by the entity.sinif value
        this.inheritingHandler();
        
        this.entity = new User_();
        return "";
    }
    
    public String deleteEntity() {
        this.getDao().delete(entity);
        this.entity = new User_();
        return "";
    }
    
    public void inheritingHandler() {
        switch( this.entity.getSinif() ) {
            case 0:
                //Superuser
                break;
            case 1:
                //Musteri
                break;
            case 2:
                //Bakici
                break;
        }
    }
}
