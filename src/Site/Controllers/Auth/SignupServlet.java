package Site.Controllers.Auth;

import Admin.Services.MailService;
import Site.Controllers.Controller;
import Site.Models.Dao.UserDao;
import Site.Models.Entities.UserEntity;
import Site.Services.UploadService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Tarek Monjur on 1/4/2018.
 */
public class SignupServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobileNo = request.getParameter("mobile_no");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setMobileNo(mobileNo);
        user.setGender(gender);
        String token = UUID.randomUUID().toString();
        user.setToken(token);

//      UploadService.upload(request, "F:\\xampp\\tomcat\\webapps\\global_pharma\\web\\public\\uploads");

//        // gets absolute path of the web application
//        String appPath = request.getServletContext().getRealPath("");
//        // constructs path of the directory to save uploaded file
//        String savePath = appPath + File.separator + "web\\public\\uploads";
//        String photo = UploadService.upload(request, savePath);
//        echo(photo);
//        echo(savePath);

        if (email != null || !email.isEmpty()) {
            UserEntity checkUser = UserDao.getByEmail(email);
            if (checkUser != null) {
                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("email", email);
                request.setAttribute("mobileNo", mobileNo);
                request.setAttribute("error_email", "The email is already exists.");
            }else {
                int result = 0;

                result = UserDao.save(user);
                if (result > 0) {
                    this.sendSignupMail(user, token);
                    request.setAttribute("flash.msg_success", "Account successfully created. Please check your verification mail.");
                    response.sendRedirect("/login");
                } else {
                    request.setAttribute("msg_error", "Account not created.Try again.");
                }
            }
        }else{
            request.setAttribute("email", email);
            request.setAttribute("error_email", "The email is required");
        }
        this.doGet(request, response);
    }


    private void sendSignupMail(UserEntity user, String token)
    {
        String link = this.baseUrl + "/verify/" + token;
        String body = "<html><body>" +
                "<h2>Hi " + user.getFirstName().toUpperCase() + " " + user.getLastName().toUpperCase() + "</h2>" +
                "<h3>Click <a href=" + link + ">hear</a> for verify your account.</h3>" +
                "</body></html>";
        MailService.send(user.getEmail(), "Account Verify", body);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.SiteSettings(request);
        String oneSegment = this.segment(1);

        if(oneSegment.equals("verify")){
            String token = this.segment(2);

            if(token !=null && !token.isEmpty()){
                UserEntity user = UserDao.getByToken(token);
                if(user !=null){
                    user.setVerifyStatus(1);
                    user.setStatus(1);
                    user.setToken("");
                    if(UserDao.update(user) > 0){
                        request.setAttribute("msg_success", "Account successfully verified. Login your account.");
                    }else{
                        request.setAttribute("msg_error", "Account not verified. Please try again.");
                    }
                }else{
                    request.setAttribute("msg_error", "Token expired. Please try again.");
                }
            }else{
                request.setAttribute("msg_error", "Token expired. Please try again.");
            }
            request.setAttribute("pageName", "./../auth/login.jsp");
        }else{
            request.setAttribute("pageName", "./../auth/signup.jsp");
        }

        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }
}
