/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.MusteriDAO;
import DAO.BakiciDAO;
import DAO.SuperuserDAO;
import DAO.UserDAO;
import Entity.Bakici;
import Entity.Musteri;
import Entity.Superuser;
import Entity.User_;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    private UserDAO userDao;
    private SuperuserDAO suDao;
    private BakiciDAO bakiciDao;
    private MusteriDAO musteriDao;
    
    private User_ entity, child;
    private boolean authorized = false;

    public SessionBean() {
    }

    public User_ getChild() {
        if(child == null) child = new User_();
        return child;
    }

    public void setChild(User_ child) {
        this.child = child;
    }
    
    public boolean isAuthorized() {
        return authorized;
    }

    public SuperuserDAO getSuDao() {
        if(suDao == null) suDao = new SuperuserDAO();
        return suDao;
    }

    public void setSuDao(SuperuserDAO suDao) {
        this.suDao = suDao;
    }

    public BakiciDAO getBakiciDao() {
        if(bakiciDao == null) bakiciDao = new BakiciDAO();
        return bakiciDao;
    }

    public void setBakiciDao(BakiciDAO bakiciDao) {
        this.bakiciDao = bakiciDao;
    }

    public MusteriDAO getMusteriDao() {
        if(musteriDao == null) musteriDao = new MusteriDAO();
        return musteriDao;
    }

    public void setMusteriDao(MusteriDAO musteriDao) {
        this.musteriDao = musteriDao;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public UserDAO getUserDao() {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
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
        User_ target = this.getUserDao().getUserByEmail(this.entity.getEmail());
        
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
            
            this.castUserType();
            
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
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        entity = new User_();
        child = new User_();
        authorized = false;
        return "/index.xhtml";
    }
    
    public void castUserType() {
        switch( this.entity.getSinif() ) {
            case 0:
                this.child = (Superuser) this.entity;
                break;
            case 1:
                this.child = (Bakici) this.getBakiciDao().findById( this.entity.getUser_id() );
                break;
            case 2:
                this.child = (Musteri) this.getMusteriDao().findById( this.entity.getUser_id() );
                break;
        }
    }
    
    public String createSu() {
        User_ tmp = new User_("su", "su@su.com", "su", 0);
        this.getUserDao().create(tmp);
        return "";
    }
}
