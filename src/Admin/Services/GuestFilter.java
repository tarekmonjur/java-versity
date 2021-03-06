package Admin.Services;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tarek Monjur on 1/2/2018.
 */
public class GuestFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        //no-op
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        HttpSession session = req.getSession(false);

        if(session !=null && session.getAttribute("admin") != null){
            res.sendRedirect("/admin/dashboard");
        }else {
            chain.doFilter(req, res);
        }

    }

    public void destroy() {
        //no-op
    }
}
