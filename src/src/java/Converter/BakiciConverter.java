/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DAO.BakiciDAO;
import Entity.Bakici;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 * One-to-Many Converter 
 */
@FacesConverter
public class BakiciConverter implements Converter {
    private BakiciDAO dao;

    public BakiciDAO getDao() {
        return dao;
    }

    public void setDao(BakiciDAO dao) {
        this.dao = dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id_param) {
        int id = Integer.parseInt(id_param);
        Bakici object = null;
        object = this.getDao().findById(id);
        return object;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Bakici o = (Bakici) t;
        String id;
        id = String.valueOf( o.getBakici_id() );
        return id;
    }
}
