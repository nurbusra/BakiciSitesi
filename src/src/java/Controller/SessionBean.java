/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.MusteriDAO;
import DAO.BakiciDAO;
import DAO.LoginLogDAO;
import DAO.SuperuserDAO;
import DAO.UserDAO;
import Entity.Bakici;
import Entity.Musteri;
import Entity.Superuser;
import Entity.User_;
import Entity.LoginLog;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    private UserDAO userDao;
    private SuperuserDAO suDao;
    private BakiciDAO bakiciDao;
    private MusteriDAO musteriDao;
    
    private User_ entity;
    private Superuser childSu;
    private Bakici childBakici;
    private Musteri childMusteri;
    private boolean authorized = false;

    public SessionBean() {
    }

    public Superuser getChildSu() {
        if(childSu == null) childSu = new Superuser();
        return childSu;
    }

    public void setChildSu(Superuser childSu) {
        this.childSu = childSu;
    }

    public Bakici getChildBakici() {
        if(childBakici == null) childBakici = new Bakici();
        return childBakici;
    }

    public void setChildBakici(Bakici childBakici) {
        this.childBakici = childBakici;
    }

    public Musteri getChildMusteri() {
        if(childMusteri == null) childMusteri = new Musteri();
        return childMusteri;
    }

    public void setChildMusteri(Musteri childMusteri) {
        this.childMusteri = childMusteri;
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
            // Failed login
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("E-posta ya da şifre hatalı."));
            System.out.println("Failed login attempt by: " + this.entity.getEmail());
            this.entity = new User_();
            return "";
        }

        else if (target.getSifre().equals( this.entity.getSifre()) ) {
            // Succesful login
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", target);
            System.out.println("Successful login by: " + this.entity.getEmail());
            this.entity = target;
            authorized = true;
            target = null;
            
            this.castUserType();
            
            this.logIpAddr();
            
            return "/index.xhtml";
        }
        
        else {
            // Failed login
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("E-posta ya da şifre hatalı."));
            System.out.println("Failed login attempt by: " + this.entity.getEmail());
            this.entity = new User_();
            return ""; 
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("validUser", entity);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        this.clearEntities();
        
        authorized = false;
        return "/index.xhtml";
    }
    
    public void castUserType() {
        switch( this.entity.getSinif() ) {
            case 0:
                this.childSu = (Superuser) this.getSuDao().findByUser_id( this.entity.getUser_id() );
                break;
            case 1:
                this.childBakici = (Bakici) this.getBakiciDao().findByUser_id( this.entity.getUser_id() );
                break;
            case 2:
                this.childMusteri = (Musteri) this.getMusteriDao().findByUser_id( this.entity.getUser_id() );
                break;
        }
    }
    
    public void logIpAddr() {
        // get ip addr and user_id
        // Create a row in login_log table
        HttpServletRequest req = 
                (HttpServletRequest) FacesContext.
                        getCurrentInstance().getExternalContext().getRequest();
        
        String ipAddress = req.getHeader("X-FORWARDED-FOR");
        
        if (ipAddress != null) {
            // cares only about the first IP if there is a list
            ipAddress = ipAddress.replaceFirst(",.*", "");
        } else {
            ipAddress = req.getRemoteAddr();
        }
        
        LoginLogDAO loginDao = new LoginLogDAO();
        LoginLog log = new LoginLog();
        
        log.setIp_addr(ipAddress);
        log.setUser_id(this.entity.getUser_id());
        
        loginDao.create(log);
    }
    
    public String createSu() {
        Superuser tmp = new Superuser("su", "su@su.com", "su", 0);
        this.getSuDao().create(tmp);
        return "";
    }
    
    private void clearEntities() {
        this.entity = new User_();
        this.childSu = new Superuser();
        this.childBakici = new Bakici();
        this.childMusteri = new Musteri();
    }
}
