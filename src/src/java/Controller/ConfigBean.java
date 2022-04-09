package Controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author ok
 */
@Named(value = "configBean")
@SessionScoped
public class ConfigBean implements Serializable {
    
    public ConfigBean() {
    } 
}
