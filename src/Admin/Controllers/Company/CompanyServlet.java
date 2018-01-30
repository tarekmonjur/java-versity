package Admin.Controllers.Company;

import Admin.Controllers.Controller;
import Admin.Models.Dao.CompanyDao;
import Admin.Models.Entities.CompanyEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tarek Monjur on 1/3/2018.
 */
public class CompanyServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        List companies = CompanyDao.getAll();
        request.setAttribute("companies", companies);
        request.setAttribute("pageName", "./../company/view.jsp");
        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }
}
