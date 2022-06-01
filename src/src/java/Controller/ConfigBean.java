package Controller;

import DAO.ConfigDAO;
import Entity.Config;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ok
 */
@Named(value = "configBean")
@SessionScoped
public class ConfigBean implements Serializable {
    
   
    private ConfigDAO dao;
    private Config entity;
    private List<Config> list;

    public ConfigDAO getDao() {
        if (this.dao == null) {
            this.dao = new ConfigDAO();
        }
        return dao;
    }

    public void setDao(ConfigDAO dao) {
        this.dao = dao;
    }

    public Config getEntity() {
        if (this.entity == null) {
            this.entity = new Config();
        }
        return entity;
    }

    public void setEntity(Config entity) {
        this.entity = entity;
    }

    public List<Config> getList() {
        this.list = this.getDao().getList();
        return this.list;
    }

    public void setList(List<Config> list) {
        this.list = list;
    }

    public void createEntity() {
        this.getDao().create(this.entity);
        this.entity = new LoginLog();
    }

    public void deleteEntity() {
        this.getDao().delete(entity);
        this.entity = new LoginLog();
        //return "/loginlog.xhtml?faces-redirect=true";
    }

    public void updateEntity() {
        this.getDao().update(this.entity);
        this.entity = new LoginLog();
    }

    public String redirectToIlanlar() {
        return "/loginlog.xhtml";
    }
}
