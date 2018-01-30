package Admin.Services;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Tarek Monjur on 1/3/2018.
 */
public abstract class DatabaseService {

    private static Connection DB;
    private static String Host;
    private static String Port;
    private static String Database;
    private static String UserName;
    private static String Password;

    private static String[] mysql = {"localhost","3306","global_pharma","root",""};
    private static String[] oracle = {"localhost","3306","global_pharma","root",""};

    protected static Connection dbConnection(String dbDriver)
    {
        if(dbDriver.equals("mysql")){
            Host = mysql[0];
            Port = mysql[1];
            Database = mysql[2];
            UserName = mysql[3];
            Password = mysql[4];
        }else if(dbDriver.equals("oracle")){
            Host = oracle[0];
            Port = oracle[1];
            Database = oracle[2];
            UserName = oracle[3];
            Password = oracle[4];
        }

        return makeConnection(dbDriver, Host, Port, Database, UserName, Password);
    }


    private static Connection makeConnection(String driver, String host, String port, String db, String userName, String password)
    {
        try{
//            if(DB == null) {
            Class.forName("com.mysql.jdbc.Driver");
            DB = DriverManager.getConnection("jdbc:"+driver+"://"+host+":"+port+"/"+db, userName, password);
//            }
        }catch(Exception e){
            System.out.println(e);
        }
        return DB;
    }
}
