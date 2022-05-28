/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import Entity.User_;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    private UserDAO dao;
    private User_ entity;
    private boolean authorized = false;

    public SessionBean() {
    }
    
    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public UserDAO getDao() {
        if (dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public User_ getEntity() {
        if (entity == null) {
            entity = new User_();
        }
        return entity;
    }

    public void setEntity(User_ entity) {
        this.entity = entity;
    }

    public String login() {
        System.out.println("login() called");
        User_ target = this.getDao().getUserByEmail(this.entity.getEmail());
        
        if (entity == null || target == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("E-posta ya da şifre hatalı."));
            System.out.println("Failed login attempt by: " + this.entity.getEmail());
            this.entity = new User_();
            return "";
        }

        else if (target.getSifre().equals( this.entity.getSifre()) ) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", target);
            System.out.println("Successful login by: " + this.entity.getEmail());
            this.entity = target;
            authorized = true;
            target = null;

            return "/index.xhtml";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("E-posta ya da şifre hatalı."));
            System.out.println("Failed login attempt by: " + this.entity.getEmail());
            this.entity = new User_();
            return ""; 
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("validUser", entity);
        entity = new User_();
        authorized = false;
        return "/index.xhtml";
    }
    
    public String createSu() {
        User_ tmp = new User_("su", "su@su.com", "su", 0);
        this.getDao().create(tmp);
        return "";
    }
}
