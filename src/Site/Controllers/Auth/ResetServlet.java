package Site.Controllers.Auth;

import Site.Controllers.Controller;
import Site.Models.Dao.UserDao;
import Site.Models.Entities.UserEntity;

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
            UserEntity user = UserDao.getByEmail(email);
            if(user != null && user.getToken().equals(token)){
                user.setPassword(password);
                user.setToken("");
                int result = UserDao.update(user);
                if(result > 0){
                    request.setAttribute("flash.msg_success", "Your password successfully changed. Now login!");
                    response.sendRedirect("/login");
                }else{
                    request.setAttribute("flash.msg_error", "Password not changed. Please try again.");
                    response.sendRedirect("/forgot");
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
        this.SiteSettings(request);
        String secondSegment = this.segment(2);
        UserEntity user = UserDao.getByToken(secondSegment);

        if(user != null){
            request.setAttribute("email", user.getEmail());
            request.setAttribute("token", user.getToken());
        }else{
            request.setAttribute("flash.msg_error", "Token expired. Please try again.");
            response.sendRedirect("/forgot");
        }

        request.setAttribute("pageName", "./../auth/reset.jsp");
        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }
}
