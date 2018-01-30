package Admin.Controllers.Auth;

import Admin.Controllers.Controller;
import Admin.Models.Dao.AdminDao;
import Admin.Models.Entities.AdminEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tarek Monjur on 12/13/2017.
 */
public class LoginServlet extends Controller {

    private int login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int result = 0;
        AdminEntity admin = null;
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        request.setAttribute("email", email);

        if(email == null || email.isEmpty()){
            request.setAttribute("error_email", "The email is required");
        }else if(password == null || password.isEmpty()){
            request.setAttribute("error_password", "The password is required");
        }
        else if(email.trim().length() > 0 && email != null && password.trim().length() > 0 && password !=null)
        {
            admin = AdminDao.authenticate(email, password);
            if(admin != null){
                result =1;
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                request.setAttribute("flash.msg_success", "Welcome. Login Success!");
                response.sendRedirect("/admin");
            }else{
                request.setAttribute("msg_error", "Email/Password mismatch!");
            }
        }

        return result;
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session=request.getSession(false);
        if(session !=null){
            session.removeAttribute("admin");
        }
        response.sendRedirect("/admin/login");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.login(request, response);
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        String secondSegment = this.segment(2);
        if(secondSegment.equals("logout"))
        {
            this.logout(request,response);
        }

        request.setAttribute("pageName", "./../auth/login.jsp");
        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+"auth.jsp");
        rd.include(request, response);
    }
}
