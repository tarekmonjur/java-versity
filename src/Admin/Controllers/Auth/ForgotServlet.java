package Admin.Controllers.Auth;

import Admin.Controllers.Controller;
import Admin.Models.Dao.AdminDao;
import Admin.Models.Entities.AdminEntity;
import Admin.Services.MailService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Tarek Monjur on 12/13/2017.
 */
public class ForgotServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String email = request.getParameter("email");
        request.setAttribute("email", email);

        if(email == null || email.isEmpty()){
            request.setAttribute("error_email", "The email is required");
        }else{
            AdminEntity admin = null;
            admin = AdminDao.getByEmail(email);

            if (admin != null && admin.getEmail().equals(email)) {
                String token = UUID.randomUUID().toString();
                String link = this.baseUrl + "/admin/reset/" + token;
                String body = "<html><body>" +
                        "<h2>Hi " + admin.getFirstName().toUpperCase() + " " + admin.getLastName().toUpperCase() + "</h2>" +
                        "<h3>Click <a href=" + link + ">hear</a> for reset your password.</h3>" +
                        "</body></html>";
                int result = MailService.send(email, "Reset Password Request", body);
                if (result > 0) {
                    admin.setToken(token);
                    AdminDao.update(admin);
                    request.setAttribute("msg_success", "Password reset request send. Please check your mail.");
                } else {
                    request.setAttribute("msg_error", "Mail not send. Please try again.");
                }
            } else {
                request.setAttribute("msg_error", "Your account is not find.");
            }
        }
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        request.setAttribute("pageName", "./../auth/forgot.jsp");
        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+"auth.jsp");
        rd.include(request, response);
    }
}
