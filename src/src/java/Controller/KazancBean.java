
package Controller;

import DAO.ConfigDAO;
import DAO.IlanDAO;
import DAO.KazancDAO;
import DAO.MusteriXilanDAO;
import Entity.Kazanc;
import Entity.MusteriXilan;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "kazancBean")
@SessionScoped
public class KazancBean implements Serializable {

    private KazancDAO dao;
    private ConfigDAO configDao;
    private MusteriXilanDAO miDao;
    private Kazanc entity;
    private List<Kazanc> list;
    
    public KazancBean() {
    }
    
    public KazancDAO getDao() {
        if(this.dao == null) this.dao = new KazancDAO();
        return dao;
    }

    public void setDao(KazancDAO dao) {
        this.dao = dao;
    }

    public Kazanc getEntity() {
        if(this.entity == null) this.entity = new Kazanc();
        return entity;
    }

    public void setEntity(Kazanc entity) {
        this.entity = entity;
    }

    public List<Kazanc> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kazanc> list) {
        this.list = list;
    }

    public ConfigDAO getConfigDao() {
        if(configDao == null) configDao = new ConfigDAO();
        return configDao;
    }

    public void setConfigDao(ConfigDAO configDao) {
        this.configDao = configDao;
    }

    public MusteriXilanDAO getMiDao() {
        if (miDao == null) miDao = new MusteriXilanDAO();
        return miDao;
    }

    public void setMiDao(MusteriXilanDAO miDao) {
        this.miDao = miDao;
    }
    
    public void createEntity(MusteriXilan m) {
        int komisyon = Integer.parseInt( this.getConfigDao().selectConfig("komisyon") );
        this.getEntity().setConfig(komisyon);
        this.getEntity().setAlisveris_id(m.getAlisveris_id());
        
        this.getDao().create(this.getEntity());
        this.entity = new Kazanc();
              
        //Update Alisveris
        m.setOdendi(true);
        this.getMiDao().update(m);
        
        //Update Ilan
        m.getIlan().setAktif(false);
        IlanDAO ilanDao = new IlanDAO();
        ilanDao.update(m.getIlan());
    }
    
    public String deleteEntity() {
        this.getDao().delete(entity);
        this.entity = new Kazanc();
        return "";
    }
    
    public void clear() {
        this.entity = new Kazanc();
    }
}
