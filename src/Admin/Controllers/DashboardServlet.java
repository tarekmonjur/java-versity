package Admin.Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tarek Monjur on 12/11/2017.
 */
public class DashboardServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        request.setAttribute("pageName", "./../dashboard.jsp");
        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }
}
