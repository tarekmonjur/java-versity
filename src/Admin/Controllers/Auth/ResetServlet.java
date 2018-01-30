package Admin.Controllers.Auth;

import Admin.Controllers.Controller;
import Admin.Models.Dao.AdminDao;
import Admin.Models.Entities.AdminEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tarek Monjur on 12/13/2017.
 */
public class ResetServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int error = 0;
        String token = request.getParameter("token");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retype_password");

        if(email == null || email.isEmpty()){
            error = 1;
            request.setAttribute("error_email", "The email is required");
        }else if(password == null || password.isEmpty()){
            error = 1;
            request.setAttribute("error_password", "The password is required");
        }else if(retypePassword == null || !retypePassword.equals(password)){
            error = 1;
            request.setAttribute("error_retype", "The password and retype password is mismatch.");
        }

        if(error <= 0){
            AdminEntity admin = AdminDao.getByEmail(email);
            if(admin != null && admin.getToken().equals(token)){
                admin.setPassword(password);
                admin.setToken("");
                int result = AdminDao.update(admin);
                if(result > 0){
                    request.setAttribute("flash.msg_success", "Your password successfully changed. Now login!");
                    response.sendRedirect("/admin/login");
                }else{
                    request.setAttribute("flash.msg_error", "Password not changed. Please try again.");
                    response.sendRedirect("/admin/forgot");
                }
            }else{
                request.setAttribute("flash.msg_error", "Token expired. Please try again.");
                this.doGet(request, response);
            }
        }else{
            this.doGet(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        String thirdSegment = this.segment(3);
        AdminEntity admin = AdminDao.getByToken(thirdSegment);

        if(admin != null){
            request.setAttribute("email", admin.getEmail());
            request.setAttribute("token", admin.getToken());
        }else{
            request.setAttribute("flash.msg_error", "Token expired. Please try again.");
            response.sendRedirect("/admin/forgot");
        }

        request.setAttribute("pageName", "./../auth/reset.jsp");
        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+"auth.jsp");
        rd.include(request, response);
    }
}
