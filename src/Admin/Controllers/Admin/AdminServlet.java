package Admin.Controllers.Admin;

import Admin.Controllers.Controller;
import Admin.Models.Dao.AdminDao;
import Admin.Models.Entities.AdminEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tarek Monjur on 12/21/2017.
 */
public class AdminServlet extends Controller {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        String secondSegment = this.segment(2);
        String thirdSegment = this.segment(3);

        if(secondSegment.equals("view"))
        {
            int pageNumber = Integer.parseInt(thirdSegment);
            pageNumber = (pageNumber < 0)?0:pageNumber;
            List admins = AdminDao.get(pageNumber,AdminEntity.pageSize);

            request.setAttribute("admins", admins);
            request.setAttribute("totalRow", AdminDao.totalRow);
            request.setAttribute("totalPage", AdminDao.totalPage);
            request.setAttribute("pageName", "./../admin/view.jsp");
        }
        else if(secondSegment.equals("delete"))
        {
            this.doDelete(request, response);
        }

        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        String thirdSegment = this.segment(3);
        int id = Integer.parseInt(thirdSegment);

        int result = AdminDao.delete(id);
        if(result > 0){
            request.setAttribute("flash.msg_success", "Admin successfully deleted.");
        }else{
            request.setAttribute("flash.msg_error", "Admin not deleted.");
        }
        response.sendRedirect("/admin/view");
    }
}
