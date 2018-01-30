package Admin.Controllers.Medicine;

import Admin.Controllers.Controller;
import Admin.Models.Dao.AdminDao;
import Admin.Models.Dao.MedicineDao;
import Admin.Models.Entities.AdminEntity;
import Admin.Models.Entities.MedicineEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tarek Monjur on 12/17/2017.
 */
public class MedicineServlet extends Controller {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        String secondSegment = this.segment(2);

        if(secondSegment.equals("view")){
            String thirdSegment = this.segment(3);
            int pageNumber = Integer.parseInt(thirdSegment);
            AdminEntity auth = this.auth(request);
            List medicines = MedicineDao.get(pageNumber, MedicineEntity.pageSize, auth.getCompanyId());

            request.setAttribute("totalPage", MedicineDao.totalPage);
            request.setAttribute("totalRow", MedicineDao.totalRow);
            request.setAttribute("medicines", medicines);
            request.setAttribute("pageName", "./../medicine/view.jsp");
        }else{
            this.doDelete(request, response);
        }
        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        String thirdSegment = this.segment(3);
        int id = Integer.parseInt(thirdSegment);

        int result = MedicineDao.delete(id);
        if(result > 0){
            request.setAttribute("flash.msg_success", "Medicine successfully deleted.");
        }else{
            request.setAttribute("flash.msg_error", "Medicine not deleted.");
        }
        response.sendRedirect("/medicine/view");
    }
}
