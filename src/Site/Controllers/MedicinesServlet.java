package Site.Controllers;

import Site.Models.Dao.MedicineDao;
import Site.Models.Entities.MedicineEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Tarek Monjur on 1/16/2018.
 */
public class MedicinesServlet extends Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.SiteSettings(request);
        String oneSegment = this.segment(1);
        String search = request.getParameter("search");
        ResultSet medicines = null;

        if(search !=null && !search.isEmpty() && search.equals("medicine")){
            int location = Integer.parseInt(request.getParameter("location"));
            int pharmacy = Integer.parseInt(request.getParameter("pharmacy"));
            String medicineName = request.getParameter("medicine_name");
            medicines= MedicineDao.searchMedicine(0, MedicineEntity.pageSize, location,pharmacy,medicineName);
            request.setAttribute("locationId", location);
            request.setAttribute("pharmacyId", pharmacy);
            request.setAttribute("medicineName", medicineName);
        }else{
            medicines= MedicineDao.get(0, MedicineEntity.pageSize);
        }

        request.setAttribute("totalPage", MedicineDao.totalPage);
        request.setAttribute("totalRow", MedicineDao.totalRow);
        request.setAttribute("medicines", medicines);
        request.setAttribute("pageName", "./../medicine/index.jsp");

        RequestDispatcher rd = request.getRequestDispatcher(this.layouts+this.layoutPage);
        rd.include(request, response);
    }
}
