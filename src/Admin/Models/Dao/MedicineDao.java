package Admin.Models.Dao;

import Admin.Models.Entities.MedicineEntity;
import Admin.Services.HibernateDatabase;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tarek Monjur on 12/27/2017.
 */
public class MedicineDao extends HibernateDatabase{

    public static int totalPage = 0;
    public static long totalRow = 0;

    public static int save(MedicineEntity medicine)
    {
        int result = 0;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            session.save(medicine);
            trans.commit();
            result = 1;
        }catch(Exception e){
            if(trans != null){
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
        return result;
    }

    public static List all()
    {
        List medicines = new ArrayList();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            medicines = session.createQuery("from MedicineEntity ").list();
            trans.commit();
        }catch (Exception e){
            if(trans !=null){
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
        return medicines;
    }

    public static List get(int pageNumber, int pageSize, int companyId)
    {
        List medicines = new ArrayList();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            Query countQuery = session.createQuery("select count(m.id) from MedicineEntity m where company_id=:cid");
            countQuery.setParameter("cid",companyId);
            totalRow = (Long) countQuery.uniqueResult();
            totalPage = (int)(totalRow / pageSize);

            Query query = session.createQuery("from MedicineEntity where company_id=:cid");
            query.setParameter("cid",companyId);
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            medicines = query.list();
            trans.commit();
        }catch (Exception e){
            if(trans !=null){
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
        return medicines;
    }


    public static MedicineEntity find(int id)
    {
        MedicineEntity medicine = null;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            medicine = session.get(MedicineEntity.class, id);
            trans.commit();
        }catch(Exception e){
            if(trans != null){
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
        return medicine;
    }


    public static int update(MedicineEntity medicine)
    {
        int result = 0;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            session.update(medicine);
            trans.commit();
            result =1;
        }catch (Exception e){
            if(trans != null){
                trans.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
        return result;
    }


    public static int delete(int id)
    {
        int result = 0;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            MedicineEntity medicine = find(id);
            session.delete(medicine);
            trans.commit();
            result = 1;
        }catch(Exception e){
            if(trans != null){
                trans.rollback();
            }
            e.printStackTrace();
        }finally{
            if(session !=null){
                session.close();
            }
        }
        return result;
    }

}
