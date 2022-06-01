/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filter;

import Entity.User_;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse resp = (HttpServletResponse) sr1;
        
        String url = req.getRequestURI();
        
        HttpSession session = req.getSession();
        
        User_ u = null;
        
        if(session != null) {
            u = (User_) session.getAttribute("validUser");
        }
        
        if(u == null) {
            // Giriş yapılmamışsa:
            if(url.contains("admin") || url.contains("ilan") || url.contains("hesabim")) {
                //Giriş Yapılması Gereken Sayfalar İsteniyorsa
                // giris.xhtml sayfasına yönlendir
                resp.sendRedirect(req.getContextPath() + "/giris.xhtml");
            }
            else {
                //Giriş Yapılması Gereken Sayfalar İstenmiyorsa
                fc.doFilter(sr, sr1);
            }
        }
        
        else {
            //Giriş yapılmışsa
            
            if(url.contains("giris") || url.contains("kayit"))
                //Giriş veya Kayıt sayfaları isteniyorsa
                resp.sendRedirect(req.getContextPath() + "/index.xhtml");
            else {
                switch(u.getSinif()) {
                    case 0:
                        // Superuser, tüm dizinlere erişim izni ver
                        fc.doFilter(sr, sr1);
                        break;

                    case 1:
                        //Bakıcı, admin hariç tüm dizinlere erişim izin ver
                        if(url.contains("admin")) 
                            resp.sendRedirect(req.getContextPath() + "/noperm.xhtml");
                        else 
                            fc.doFilter(sr, sr1);
                        break;

                    case 2:
                        //Müşteri, admin ve ilanolustur.xhtml hariç tüm dizinlere erişim izin ver
                        if(url.contains("admin") || url.contains("ilanolustur")) 
                            resp.sendRedirect(req.getContextPath() + "/noperm.xhtml");
                        else 
                            fc.doFilter(sr, sr1);
                        break;
                } //Switch
            } //Else
        } //Else
    } //Method
} //Class
