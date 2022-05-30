/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DAO.MusteriXilanDAO;
import Entity.MusteriXilan;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Merve
 */
@FacesConverter("musterixilanConverter")
public class MusteriXilanConverter implements Converter {
     private MusteriXilanDAO dao;
     public MusteriXilanDAO getDao() {
        return dao;
    }

    public void setDao(MusteriXilanDAO dao) {
        this.dao = dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id_param) {
        int id = Integer.parseInt(id_param);
        MusteriXilan object = null;
        object = this.getDao().findById(id);
        return object;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        MusteriXilan o = (MusteriXilan) t;
        String id;
        id = String.valueOf( o.getAlisveris_id() );
        return id;
    }
     
    
    
    
    
}
