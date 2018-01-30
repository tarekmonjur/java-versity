package Site.Models.Dao;

import Admin.Models.Entities.AdminEntity;
import Admin.Models.Entities.RoleEntity;
import Admin.Services.HibernateDatabase;
import Site.Models.Entities.PharmacyEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tarek Monjur on 1/3/2018.
 */
public class PharmacyDao extends HibernateDatabase{

    public static int registration(PharmacyEntity company)
    {
        Transaction trans = null;
        Session session = getSession();
        int result = 0;

        try{
            trans = session.beginTransaction();
            session.save(company);
            result = company.getId();
            trans.commit();
        }catch (Exception e){
            if(trans !=null){
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session !=null){
                session.close();
            }
        }

        return result;
    }


    public static List<PharmacyEntity> all()
    {
        List<PharmacyEntity> companies = new ArrayList<>();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            companies = session.createQuery("from PharmacyEntity").list();
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
        return companies;
    }


    public static List<PharmacyEntity> get()
    {
        List<PharmacyEntity> companies = new ArrayList<>();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            companies = session.createQuery("from PharmacyEntity inner join LocationEntity").list();
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
        return companies;
    }



}
