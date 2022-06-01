/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.LoginLogDAO;
import Entity.LoginLog;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author busra
 */
@Named(value = "LoginLogBean")
@SessionScoped
public class LoginLogBean implements Serializable {

    private LoginLogDAO dao;
    private LoginLog entity;
    private List<LoginLog> list;

    public LoginLogDAO getDao() {
        if (this.dao == null) {
            this.dao = new LoginLogDAO();
        }
        return dao;
    }

    public void setDao(LoginLogDAO dao) {
        this.dao = dao;
    }

    public LoginLog getEntity() {
        if (this.entity == null) {
            this.entity = new LoginLog();
        }
        return entity;
    }

    public void setEntity(LoginLog entity) {
        this.entity = entity;
    }

    public List<LoginLog> getList() {
        this.list = this.getDao().getList();
        return this.list;
    }

    public void setList(List<LoginLog> list) {
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