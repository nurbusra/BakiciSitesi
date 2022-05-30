
package Converter;
import DAO.KazancDAO;
import Entity.Kazanc;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Merve
 */
@FacesConverter("kazancConverter")
public class KazancConverter implements Converter{
    private KazancDAO dao;

    public KazancDAO getDao() {
        return dao;
    }

    public void setDao(KazancDAO dao) {
        this.dao = dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id_param) {
        int id = Integer.parseInt(id_param);
        Kazanc object = null;
        object = this.getDao().findById(id);
        return object;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kazanc o = (Kazanc) t;
        String id;
        id = String.valueOf( o.getKazanc_id() );
        return id;
    }
    
    
}
