package Admin.Models.Dao;

import Admin.Models.Entities.CompanyEntity;
import Admin.Services.DatabaseService;

import java.sql.*;
import java.util.*;

/**
 * Created by Tarek Monjur on 1/3/2018.
 */
public class CompanyDao extends DatabaseService{

    private static String dbDriver = "mysql";
    private static String Table = "companies";

    public static List getAll()
    {
        List list = new ArrayList<>();
        int rows=1;

        try {
            Connection DB = DatabaseService.dbConnection(dbDriver);
            String query = "select * from " + Table + " as c inner join locations as l on l.id=c.location_id";
            PreparedStatement pstmt = DB.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CompanyEntity company = new CompanyEntity();
                company.setRow(rows);
                company.setId(rs.getInt(1));
                company.setCompanyName(rs.getString(3));
                company.setCompanyCode(rs.getString(4));
                company.setCompanyContactEmail(rs.getString(5));
                company.setCompanyContactMobileNo(rs.getString(6));
                company.setCompanyLogo(rs.getString(7));
                company.setCompanyAddress(rs.getString(8));
                company.setCompanyStatus(rs.getString(9));
                company.setCreatedAt(rs.getString(10));
                company.setUpdatedAt(rs.getString(11));
                list.add(company);
                rows++;
            }
            DB.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
