package Admin.Controllers.Role;

import Admin.Controllers.Controller;
import Admin.Models.Dao.RoleDao;
import Admin.Models.Entities.AdminEntity;
import Admin.Models.Entities.RoleEntity;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tarek Monjur on 12/19/2017.
 */
public class RoleServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String role_name = request.getParameter("role_name");
        String role_description = request.getParameter("role_description");

        int result = 0;
        RoleEntity role = new RoleEntity();
        AdminEntity auth = this.auth(request);
        role.setCompanyId(auth.getCompanyId());
        role.setRoleName(role_name);
        role.setRoleDescription(role_description);
        role.setRolePermission("role permission");

        if(request.getParameterMap().containsKey("_method") && request.getParameterMap() !=null){
            String formMethod = request.getParameter("_method");
            if(formMethod.equals("put") || formMethod.equals("PUT")) {
                this.doPut(request, response, role);
            }
        }else{
            result = RoleDao.save(role);
            if(result > 0){
                request.setAttribute("flash.msg_success", "Role successfully created.");
                response.sendRedirect("/role/view");
            }else{
                request.setAttribute("msg_error", "Role not created.");
                request.setAttribute("role_name", role_name);
                request.setAttribute("role_description", role_description);
            }
        }

        this.doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        String secondSegment = this.segment(2);
        String thridSegment = this.segment(3);

        if(secondSegment.equals("add"))
        {
            request.setAttribute("pageName", "./../role/add.jsp");
        }
        else if(secondSegment.equals("view"))
        {
            int pageNumber = Integer.parseInt(thridSegment);
            if(pageNumber < 0){
                pageNumber = 0;
            }
            List<RoleEntity> roles = RoleDao.get(pageNumber, RoleEntity.pageSize);
            request.setAttribute("totalRow", RoleDao.totalRow);
            request.setAttribute("totalPage", RoleDao.totalPage);
            request.setAttribute("roles", roles);
            request.setAttribute("pageName", "./../role/view.jsp");
        }
        else if(secondSegment.equals("edit"))
        {
            int id = Integer.parseInt(thridSegment);
            request.setAttribute("id", id);
            RoleEntity role = RoleDao.find(id);
            if(role == null){
                request.setAttribute("flash.msg_error", "Data not found.");
                response.sendRedirect("/role/view");
            }else{
                request.setAttribute("role", role);
                request.setAttribute("pageName", "./../role/edit.jsp");
            }
        }
        else if(secondSegment.equals("delete"))
        {
            this.doDelete(request, response);
        }

        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response, RoleEntity role) throws ServletException, IOException
    {
        this.appSettings(request);
        String thridSegment = this.segment(3);
        int id = Integer.parseInt(thridSegment);
        role.setId(id);
        int result = RoleDao.update(role);
        if(result > 0){
            request.setAttribute("flash.msg_success", "Role successfully update.");
            response.sendRedirect("/role/view");
        }else{
            request.setAttribute("flash.msg_error", "Role not update.");
        }
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        String thirdSegment = this.segment(3);
        int id = Integer.parseInt(thirdSegment);

        int result = RoleDao.delete(id);
        if(result > 0){
            request.setAttribute("flash.msg_success", "Role successfully deleted.");
        }else{
            request.setAttribute("flash.msg_error", "Role not deleted.");
        }
        response.sendRedirect("/role/view");
    }

}
