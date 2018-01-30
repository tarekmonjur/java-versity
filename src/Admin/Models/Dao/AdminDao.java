package Admin.Models.Dao;

import Admin.Models.Entities.AdminEntity;
import Admin.Services.HibernateDatabase;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tarek Monjur on 12/21/2017.
 */
public class AdminDao extends HibernateDatabase{

    public static int totalPage = 0;
    public static long totalRow = 0;

    public static AdminEntity authenticate(String email, String password)
    {
        AdminEntity admin = null;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from AdminEntity where email = :email and password = :password and status = :status");
            query.setParameter("email", email);
            query.setParameter("password", password);
            query.setParameter("status", 1);
            AdminEntity adminResult = (AdminEntity) query.uniqueResult();
            trans.commit();
            if(adminResult !=null && adminResult.getEmail().equals(email) && adminResult.getPassword().equals(password)){
                admin = adminResult;
            }
        }catch (Exception e){
            if(trans != null){
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
        return admin;
    }

    public static int save(AdminEntity admin)
    {
        int result = 0;
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            session.save(admin);
            result = admin.getId();
            trans.commit();
        }catch (Exception e){
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }
        }
        return result;
    }


    public static List all()
    {
        List admins = new ArrayList();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            admins = session.createQuery("from AdminEntity").list();
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
        return admins;
    }

    public static List get(int pageNumber, int pageSize)
    {
        List admins = new ArrayList();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            Query countQuery = session.createQuery("select count(a.id) from AdminEntity a");
            totalRow = (Long) countQuery.uniqueResult();
            totalPage = (int)(totalRow / pageSize);

            Query query = session.createQuery("from AdminEntity");
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            admins = query.list();
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
        return admins;
    }


    public static AdminEntity find(int id)
    {
        AdminEntity admin = null;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            admin = session.get(AdminEntity.class, id);
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
        return admin;
    }


    public static int update(AdminEntity admin)
    {
        int result = 0;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            session.update(admin);
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
            AdminEntity admin = find(id);
            session.delete(admin);
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


    public static AdminEntity getByEmail(String email)
    {
        AdminEntity admin = null;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from AdminEntity where email=?");
            query.setParameter(0,email);
            admin = (AdminEntity) query.uniqueResult();
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
        return admin;
    }

    public static AdminEntity getByToken(String token)
    {
        AdminEntity admin = null;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from AdminEntity where token=?");
            query.setParameter(0,token);
            admin = (AdminEntity) query.uniqueResult();
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
        return admin;
    }


}
