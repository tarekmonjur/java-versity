package Site.Controllers.Auth;

import Site.Controllers.Controller;
import Site.Models.Dao.UserDao;
import Site.Models.Entities.UserEntity;

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
        UserEntity user = null;
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
            user = UserDao.authenticate(email, password);
            if(user != null){
                result =1;
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.setAttribute("flash.msg_success", "Welcome. Login Success!");
                response.sendRedirect("/dashboard");
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
            session.removeAttribute("user");
        }
        response.sendRedirect("/");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.login(request, response);
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.SiteSettings(request);
        String secondSegment = this.segment(1);
        if(secondSegment.equals("logout"))
        {
            this.logout(request,response);
        }

        request.setAttribute("pageName", "./../auth/login.jsp");
        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }
}
