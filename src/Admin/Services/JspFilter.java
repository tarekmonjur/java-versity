package Admin.Services;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Tarek Monjur on 12/19/2017.
 */
public class JspFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req= (HttpServletRequest) request;
        req.getRequestDispatcher("/views/admin/errors/404.jsp").forward(request, response);
    }

    @Override
    public void destroy() {

    }
}