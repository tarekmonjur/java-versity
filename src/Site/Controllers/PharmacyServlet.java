package Site.Controllers;


import Admin.Models.Dao.AdminDao;
import Admin.Models.Dao.RoleDao;
import Admin.Models.Entities.AdminEntity;
import Admin.Models.Entities.RoleEntity;
import Site.Models.Dao.PharmacyDao;
import Site.Models.Entities.PharmacyEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tarek Monjur on 1/8/2018.
 */
public class PharmacyServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            int company_id = 0;
            int role_id = 0;

            String companyName = request.getParameter("companyName");
            String companyCode = request.getParameter("companyCode");
            String companyContactEmail = request.getParameter("companyContactEmail");
            String companyContactMobileNo = request.getParameter("companyContactMobileNo");
            String password = request.getParameter("password");
            String location = request.getParameter("location");
            int locationId = Integer.parseInt(location);
            String companyLogo = request.getParameter("companyLogo");
            String pharmacyAddress = request.getParameter("pharmacyAddress");

            PharmacyEntity company = new PharmacyEntity();
            company.setCompanyName(companyName);
            company.setLocationId(locationId);
            company.setCompanyCode(companyCode);
            company.setCompanyContactEmail(companyContactEmail);
            company.setCompanyContactMobileNo(companyContactMobileNo);
            company.setCompanyAddress(pharmacyAddress);
            company.setCompanyStatus("pending");
            company_id = PharmacyDao.registration(company);

            if(company_id > 0) {
                RoleEntity role = new RoleEntity();
                role.setCompanyId(company_id);
                role.setRoleName("Admin");
                role.setRoleDescription("Admin account");
                role.setRolePermission("");
                role_id = RoleDao.save(role);

                if(role_id > 0){
                    AdminEntity admin = new AdminEntity();
                    admin.setCompanyId(company_id);
                    admin.setRoleId(role_id);
                    admin.setLastName(companyName);
                    admin.setFirstName(companyName);
                    admin.setEmail(companyContactEmail);
                    admin.setPassword(password);
                    admin.setAdminType("pharmacy");
                    admin.setMobileNo(companyContactMobileNo);
                    admin.setStatus(0);
                    int admin_id = AdminDao.save(admin);
                }
            }
            request.setAttribute("flash.msg_success", "Pharmacy registration success. After authority verify you can access your system.");

        }catch (Exception e){
            request.setAttribute("flash.msg_error", "Pharmacy registration failed. Please try again later.");
            e.printStackTrace();
        }

        response.sendRedirect("/registration");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.SiteSettings(request);
        String oneSegment = this.segment(1);

        if(oneSegment !=null && oneSegment.equals("registration")){
            request.setAttribute("pageName", "./../pharmacy/add.jsp");
        }else{
            request.setAttribute("pageName", "./../pharmacy/index.jsp");
        }

        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }


}
