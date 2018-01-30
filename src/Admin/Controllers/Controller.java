package Admin.Controllers;


import Admin.Models.Entities.AdminEntity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by Tarek Monjur on 12/11/2017.
 */
public abstract class Controller extends HttpServlet{

    protected String appName = "AFC Pharmacy";
    protected String appFirstName = "AFC";
    protected String appLastName = "Pharmacy";
    protected String appMobileNumber = "+8801832308565";
    protected String appEmailAddress =  "support@afc.com";

    protected String scheme;
    protected String serverName;
    protected String serverPort;
    protected String contextPath;
    protected String pathInfo;
    protected String uri;
    protected String requestMethod;
    protected String baseUrl;
    protected String assets;
    protected String files;
    protected String layouts;
    protected String layoutPage;

    protected String appSettings(HttpServletRequest request)
    {
        this.scheme = request.getScheme();
        this.serverName = request.getServerName();
        this.serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
        this.contextPath = request.getContextPath();
        this.uri = request.getRequestURI();
        this.pathInfo = request.getPathInfo();
        this.requestMethod = request.getMethod();
        this.baseUrl = this.scheme+"://"+this.serverName+this.serverPort+this.contextPath;
        this.assets = this.baseUrl+"/public/assets/";
        this.files = this.baseUrl+"/public/uploads/";
        this.layouts = "/views/admin/layouts/";
        this.layoutPage = "layout.jsp";

        request.setAttribute("appName", this.appName);
        request.setAttribute("appFirstName", this.appFirstName);
        request.setAttribute("appLastName", this.appLastName);
        request.setAttribute("appMobileNumber", this.appMobileNumber);
        request.setAttribute("appEmailAddress", this.appEmailAddress);

        request.setAttribute("baseUrl", this.baseUrl);
        request.setAttribute("uri1", this.segment(1));
        request.setAttribute("uri2", this.segment(2));
        request.setAttribute("assets", this.assets);
        request.setAttribute("files", this.files);
        request.setAttribute("layouts", this.layouts);

        return this.baseUrl;
    }


    protected String segment(int segment){
        String[] segmentPart = this.uri.split("/");
        if(segmentPart.length > segment){
            return segmentPart[segment];
        }else {
            return "0";
        }
    }


    protected AdminEntity auth(HttpServletRequest request){
        HttpSession authSessionCheck = request.getSession(false);
        AdminEntity auth = (AdminEntity) authSessionCheck.getAttribute("admin");
        return auth;
    }

}
