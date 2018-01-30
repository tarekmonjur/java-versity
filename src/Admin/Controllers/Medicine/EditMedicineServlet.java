package Admin.Controllers.Medicine;

import Admin.Controllers.Controller;
import Admin.Models.Dao.AdminDao;
import Admin.Models.Dao.MedicineDao;
import Admin.Models.Entities.AdminEntity;
import Admin.Models.Entities.MedicineEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tarek Monjur on 12/27/2017.
 */
public class EditMedicineServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String company_id = request.getParameter("company_id");
        String medicineCode = request.getParameter("medicine_code");
        String medicineName = request.getParameter("medicine_name");
        String medicineGeneric = request.getParameter("medicine_generic");
        String medicineCompany = request.getParameter("medicine_company");
        String medicineType = request.getParameter("medicine_type");
        String medicineSize = request.getParameter("medicine_size");
        String medicineUnit = request.getParameter("medicine_unit");
        String medicinePrice = request.getParameter("medicine_price");

        MedicineEntity medicine = new MedicineEntity();
        medicine.setCompanyId(Integer.parseInt(company_id));
        medicine.setMedicineCode(medicineCode);
        medicine.setMedicineName(medicineName);
        medicine.setMedicineGeneric(medicineGeneric);
        medicine.setMedicineCompanyName(medicineCompany);
        medicine.setMedicineType(medicineType);
        medicine.setMedicineSize(medicineSize);
        medicine.setMedicineUnit(medicineUnit);
        medicine.setMedicinePrice(Float.parseFloat(medicinePrice));

        this.appSettings(request);
        String thridSegment = this.segment(3);
        int id = Integer.parseInt(thridSegment);
        medicine.setId(id);
        int result = MedicineDao.update(medicine);
        if(result > 0){
            request.setAttribute("flash.msg_success", "Medicine successfully updated.");
            response.sendRedirect("/medicine/view");
        }else{
            request.setAttribute("msg_error", "Medicine not updated.");
            this.doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        String thirdSegment = this.segment(3);
        int id = Integer.parseInt(thirdSegment);
        MedicineEntity medicine = MedicineDao.find(id);

        if(medicine == null){
            request.setAttribute("flash.msg_error", "Data not found.");
            response.sendRedirect("/medicine/view");
        }else{
            request.setAttribute("id", id);
            request.setAttribute("medicine", medicine);
            request.setAttribute("pageName", "./../medicine/edit.jsp");
        }

        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }
}
