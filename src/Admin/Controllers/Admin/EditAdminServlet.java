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
 * Created by Tarek Monjur on 12/25/2017.
 */
public class EditAdminServlet extends Controller {

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
        admin.setMobileNo(mobile_no);
        admin.setAdminType(auth.getAdminType());

        this.appSettings(request);
        String thridSegment = this.segment(3);
        int id = Integer.parseInt(thridSegment);

        AdminEntity getAdmin = AdminDao.find(id);
        if(!password.isEmpty()){
            admin.setPassword(password);
        }else{
            admin.setPassword(getAdmin.getPassword());
        }
        admin.setId(id);
        admin.setStatus(getAdmin.getStatus());
        admin.setPhoto(getAdmin.getPhoto());
        int result = AdminDao.update(admin);

        if(result > 0){
            request.setAttribute("flash.msg_success", "Admin successfully updated.");
            response.sendRedirect("/admin/view");
        }else{
            request.setAttribute("msg_error", "Admin not updated.");
            this.doGet(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        String thirdSegment = this.segment(3);
        int id = Integer.parseInt(thirdSegment);
        AdminEntity admin = AdminDao.find(id);

        if(admin == null){
            request.setAttribute("flash.msg_error", "Data not found.");
            response.sendRedirect("/admin/view");
        }else{
            request.setAttribute("id", id);
            request.setAttribute("admin", admin);
            AdminEntity auth = this.auth(request);
            List roles = RoleDao.getRoleByCompanyId(auth.getCompanyId());
            request.setAttribute("roles", roles);
            request.setAttribute("pageName", "./../admin/edit.jsp");
        }

        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }

}
