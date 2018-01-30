package Site.Controllers;

import Site.Models.Dao.LocationDao;
import Site.Models.Dao.PharmacyDao;
import Site.Models.Entities.LocationEntity;
import Site.Models.Entities.PharmacyEntity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.List;

/**
 * Created by Tarek Monjur on 1/4/2018.
 */
public class Controller extends HttpServlet {

    protected String appName = "GLOBAL MEDICINE";
    protected String appFirstName = "GLOBAL";
    protected String appLastName = "MEDICINE";
    protected String appMobileNumber = "+8801832308565";
    protected String appEmailAddress =  "support@globalmedicine.com";

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

    protected String SiteSettings(HttpServletRequest request)
    {
        this.scheme = request.getScheme();
        this.serverName = request.getServerName();
        this.serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
        this.contextPath = request.getContextPath();
        this.uri = request.getRequestURI();
        this.pathInfo = request.getPathInfo();
        this.requestMethod = request.getMethod();
        this.baseUrl = this.scheme+"://"+this.serverName+this.serverPort+this.contextPath;
        this.assets = this.baseUrl+"/public/assets/site";
        this.files = this.baseUrl+"/public/uploads/";
        this.layouts = "/views/site/layouts/";
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

        List<LocationEntity> locations = LocationDao.all();
        request.setAttribute("locations", locations);

        List<PharmacyEntity> pharmacies = PharmacyDao.all();
        request.setAttribute("pharmacies", pharmacies);

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

    protected String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    public static void echo(int echo){
        System.out.println("Echo = "+echo);
    }

    public static void echo(String echo){ System.out.println("Echo = "+echo); }

}
