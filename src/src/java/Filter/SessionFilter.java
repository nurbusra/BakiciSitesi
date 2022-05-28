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
            if(url.contains("admin") || url.contains("ilanlar")) {
                resp.sendRedirect(req.getContextPath() + "/giris.xhtml");
            }
            else {
                fc.doFilter(sr, sr1);
            }
        }
        
        else {
            if(url.contains("admin")) {
                if(u.getSinif() == 0) {
                    fc.doFilter(sr, sr1);
                }
                else {
                    resp.sendRedirect(req.getContextPath() + "/noperm.xhtml");
                }
            }
            
            else if(url.contains("kayit") || url.contains("giris")) {
                resp.sendRedirect(req.getContextPath() + "/index.xhtml");
            }
            else {
                fc.doFilter(sr, sr1);
            }
        }
    }
}
