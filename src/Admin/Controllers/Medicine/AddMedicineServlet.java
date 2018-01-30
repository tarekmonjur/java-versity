package Admin.Controllers.Medicine;

import Admin.Controllers.Controller;
import Admin.Models.Dao.MedicineDao;
import Admin.Models.Entities.AdminEntity;
import Admin.Models.Entities.MedicineEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tarek Monjur on 12/17/2017.
 */
public class AddMedicineServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String medicineCode = request.getParameter("medicine_code");
        String medicineName = request.getParameter("medicine_name");
        String medicineGeneric = request.getParameter("medicine_generic");
        String medicineCompany = request.getParameter("medicine_company");
        String medicineType = request.getParameter("medicine_type");
        String medicineSize = request.getParameter("medicine_size");
        String medicineUnit = request.getParameter("medicine_unit");
        String medicinePrice = request.getParameter("medicine_price");

        MedicineEntity medicine = new MedicineEntity();
        AdminEntity auth = this.auth(request);
        medicine.setCompanyId(auth.getCompanyId());
        medicine.setMedicineCode(medicineCode);
        medicine.setMedicineName(medicineName);
        medicine.setMedicineGeneric(medicineGeneric);
        medicine.setMedicineCompanyName(medicineCompany);
        medicine.setMedicineType(medicineType);
        medicine.setMedicineSize(medicineSize);
        medicine.setMedicineUnit(medicineUnit);
        medicine.setMedicinePrice(Float.parseFloat(medicinePrice));

        int result = MedicineDao.save(medicine);
        if(result > 0){
            request.setAttribute("flash.msg_success", "Medicine successfully added.");
            response.sendRedirect("/medicine/view");
        }else{
            request.setAttribute("medicineCode", medicineCode);
            request.setAttribute("medicineName", medicineName);
            request.setAttribute("medicineGeneric", medicineGeneric);
            request.setAttribute("medicineCompany", medicineCompany);
            request.setAttribute("medicineType", medicineType);
            request.setAttribute("medicineSize", medicineSize);
            request.setAttribute("medicineUnit", medicineUnit);
            request.setAttribute("medicinePrice", medicinePrice);
            request.setAttribute("msg_error", "Medicine not added.");
           this.doGet(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.appSettings(request);
        request.setAttribute("pageName", "./../medicine/add.jsp");
        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }
}
