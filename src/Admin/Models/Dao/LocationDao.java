package Admin.Models.Dao;

import Admin.Models.Entities.LocationEntity;
import Admin.Services.DatabaseService;

import java.math.BigInteger;
import java.sql.*;
import java.util.*;

/**
 * Created by Tarek Monjur on 1/9/2018.
 */
public class LocationDao extends DatabaseService{

    private static String dbDriver = "mysql";
    private static String Table = "locations";

    public static List getAll()
    {
        List list = new ArrayList<>();
        int rows=1;

        try {
            Connection DB = DatabaseService.dbConnection(dbDriver);
            String query = "select * from "+Table;
            PreparedStatement pstmt = DB.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LocationEntity location = new LocationEntity();
                location.setRow(rows);
                location.setId(rs.getInt(1));
                location.setLocationName(rs.getString(2));
                list.add(location);
                rows++;
            }
            DB.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
