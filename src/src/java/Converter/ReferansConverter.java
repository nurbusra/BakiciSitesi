
package Converter;
import DAO.ReferansDAO;
import Entity.Referans;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Merve
 */
@FacesConverter("referansConverter")
public class ReferansConverter implements Converter {
    private ReferansDAO dao;
     public ReferansDAO getDao() {
        return dao;
    }

    public void setDao(ReferansDAO dao) {
        this.dao = dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id_param) {
        int id = Integer.parseInt(id_param);
        Referans object = null;
        object = this.getDao().findById(id);
        return object;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Referans o = (Referans) t;
        String id;
        id = String.valueOf( o.getRef_id() );
        return id;
    }
    
    
}
