/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DAO.MusteriDAO;
import Entity.Musteri;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 * Many-to-Many Converter 
 */
@FacesConverter
public class MusteriConverter implements Converter {
    private MusteriDAO dao;

    public MusteriDAO getDao() {
        return dao;
    }

    public void setDao(MusteriDAO dao) {
        this.dao = dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id_param) {
        int id = Integer.parseInt(id_param);
        Musteri object = null;
        object = this.getDao().findById(id);
        return object;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Musteri o = (Musteri) t;
        String id;
        id = String.valueOf( o.getMusteri_id() );
        return id;
    }
}
