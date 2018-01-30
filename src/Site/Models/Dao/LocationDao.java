package Site.Models.Dao;

import Admin.Services.HibernateDatabase;
import Site.Models.Entities.LocationEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tarek Monjur on 1/28/2018.
 */
public class LocationDao extends HibernateDatabase{

    public static List<LocationEntity> all()
    {
        List<LocationEntity> locations = new ArrayList<>();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            locations = (List<LocationEntity>) session.createQuery("from LocationEntity").list();
            trans.commit();
        }catch(Exception e){
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }
        }
        return locations;
    }
}
