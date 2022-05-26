/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.BakiciDAO;
import DAO.MusteriDAO;
import Entity.Bakici;
import Entity.Musteri;
import Entity.User_;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;


@Named(value = "kayitBean")
@SessionScoped
public class KayitBean implements Serializable {

    @NotBlank private User_ entity;
    @NotBlank private BakiciDAO bakiciDao;
    @NotBlank private MusteriDAO musteriDao;
    public KayitBean() {
    }
    
    public boolean validateEmail(FacesContext context , UIComponent cmp , Object value) throws ValidatorException{
        String v= (String) value;
        if(v.isEmpty()){
            throw new ValidatorException(new FacesMessage("Şifre alanı boş bırakılamaz!"));
        }else if(v.length() < 7 ){
            throw new ValidatorException(new FacesMessage("Şifre alanı 8 karakterden az olamaz!"));
        }
        return true;
    }
    public void register(){
        System.out.println("-------REGISTERED-----");
    }

    

    public User_ getEntity() {
        if(this.entity == null) this.entity = new User_();
        return entity;
    }

    public void setEntity(User_ entity) {
        this.entity = entity;
    }

    public BakiciDAO getBakiciDao() {
        if(this.bakiciDao == null) this.bakiciDao = new BakiciDAO();
        return bakiciDao;
    }

    public void setBakiciDao(BakiciDAO bakiciDao) {
        this.bakiciDao = bakiciDao;
    }

    public MusteriDAO getMusteriDao() {
        if(this.musteriDao == null) this.musteriDao = new MusteriDAO();
        return musteriDao;
    }

    public void setMusteriDao(MusteriDAO musteriDao) {
        this.musteriDao = musteriDao;
    }
    
    
    public String createEntity() {
        if(this.entity.getSinif() == 1) {
            // Musteri
            Musteri o = new Musteri(
                    this.entity.getIsim(),
                    this.entity.getEmail(),
                    this.entity.getSifre(),
                    this.entity.getSinif()
                    );
            this.getMusteriDao().create(o);
        }
        else if(this.entity.getSinif() == 2) {
            // Bakici
            Bakici o = new Bakici(
                    this.entity.getIsim(),
                    this.entity.getEmail(),
                    this.entity.getSifre(),
                    this.entity.getSinif()
                    );
            this.getBakiciDao().create(o);
        }
        this.entity = new User_();
        return "users.xhtml?faces-redirect=true";
    }
}
