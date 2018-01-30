package Admin.Controllers.Admin;

import Admin.Controllers.Controller;
import Admin.Models.Dao.AdminDao;
import Admin.Models.Dao.RoleDao;
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
public class AddAdminServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile_no = request.getParameter("mobile_no");
        String roleId = request.getParameter("role_id");

        AdminEntity admin = new AdminEntity();
        AdminEntity auth = this.auth(request);
        admin.setCompanyId(auth.getCompanyId());
        admin.setRoleId(Integer.parseInt(roleId));
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setMobileNo(mobile_no);

        int result;
        result = AdminDao.save(admin);
        if(result > 0){
            request.setAttribute("flash.msg_success", "Admin successfully created.");
            response.sendRedirect("/admin/view");
        }else{
            request.setAttribute("msg_error", "Admin not created.");
            this.doGet(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        AdminEntity auth = this.auth(request);
        List roles = RoleDao.getRoleByCompanyId(auth.getCompanyId());
        request.setAttribute("roles", roles);
        request.setAttribute("pageName", "./../admin/add.jsp");
        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }
}
