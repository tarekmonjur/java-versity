package Site.Models.Dao;

import Admin.Services.DatabaseService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tarek Monjur on 1/16/2018.
 */
public class MedicineDao extends DatabaseService {

    private static String dbDriver = "mysql";
    private static String Table = "medicines";

    public static int totalPage = 0;
    public static long totalRow = 0;

    public static ResultSet searchMedicine(int pageNumber, int pageSize, int locationId, int companyId, String medicineName)
    {
        ResultSet medicines = null;
        try{
            Connection DB = DatabaseService.dbConnection(dbDriver);
            String query = "select m.*,c.company_name,c.company_address,c.company_contact_mobile_no,l.location_name from medicines m" +
                    " INNER JOIN companies as c ON c.id = m.company_id" +
                    " INNER JOIN locations as l ON l.id = c.location_id" +
                    " WHERE m.medicine_status =? AND m.medicine_name LIKE ?";

            if(companyId > 0){
                query += " AND m.company_id=?";
            }else if(locationId > 0){
                query += " AND l.id=?";
            }

            System.out.println("MEDICINE = "+ query);
            PreparedStatement pstmt = DB.prepareStatement(query);

            pstmt.setString(1,"verified");
            pstmt.setString(2,"%" + medicineName + "%");

            if(companyId > 0){
                pstmt.setInt(3,companyId);
            }else if(locationId > 0){
                pstmt.setInt(3,locationId);
            }

            ResultSet rs = pstmt.executeQuery();
            medicines = rs;
        }catch (Exception e){
            e.printStackTrace();
        }
        return medicines;
    }


    public static ResultSet get(int pageNumber, int pageSize)
    {
        ResultSet medicines = null;
        try{
            Connection DB = DatabaseService.dbConnection(dbDriver);
            String query = "select m.*,c.company_name,c.company_address,c.company_contact_mobile_no,l.location_name from medicines m" +
                    " INNER JOIN companies as c ON c.id = m.company_id" +
                    " INNER JOIN locations as l ON l.id = c.location_id" +
                    " where m.medicine_status =?";
                    PreparedStatement pstmt = DB.prepareStatement(query);
            pstmt.setString(1,"verified");
            ResultSet rs = pstmt.executeQuery();
            medicines = rs;
        }catch (Exception e){
            e.printStackTrace();
        }
        return medicines;
    }


//    public static MedicineEntity find(int id)
//    {
//        MedicineEntity medicine = null;
//        Transaction trans = null;
//        Session session = getSession();
//
//        try{
//            trans = session.beginTransaction();
//            medicine = session.get(MedicineEntity.class, id);
//            trans.commit();
//        }catch(Exception e){
//            if(trans != null){
//                trans.rollback();
//            }
//            e.printStackTrace();
//        }finally {
//            if(session != null){
//                session.close();
//            }
//        }
//        return medicine;
//    }



}

