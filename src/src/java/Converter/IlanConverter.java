/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DAO.IlanDAO;
import Entity.Ilan;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 * Many-to-Many Converter 
 */
@FacesConverter("ilanConverter")
public class IlanConverter implements Converter {
    private IlanDAO dao;

    public IlanDAO getDao() {
        if(dao == null) dao = new IlanDAO();
        return dao;
    }

    public void setDao(IlanDAO dao) {
        this.dao = dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id_param) {
        int id = Integer.parseInt(id_param);
        Ilan object = null;
        object = this.getDao().findById(id);
        return object;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Ilan o = (Ilan) t;
        String id;
        id = String.valueOf( o.getIlan_id() );
        return id;
    }
}
