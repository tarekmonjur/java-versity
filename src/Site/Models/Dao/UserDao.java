package Site.Models.Dao;

import Admin.Models.Entities.MedicineEntity;
import Admin.Services.HibernateDatabase;
import Site.Models.Entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tarek Monjur on 1/6/2018.
 */

public class UserDao extends HibernateDatabase{

    public static int totalPage = 0;
    public static long totalRow = 0;

    public static UserEntity authenticate(String email, String password)
    {
        UserEntity user = null;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from UserEntity where email = :email and password = :password and status = :status");
            query.setParameter("email", email);
            query.setParameter("password", password);
            query.setParameter("status", 1);
            UserEntity userResult = (UserEntity) query.uniqueResult();
            trans.commit();
            if(userResult !=null && userResult.getEmail().equals(email) && userResult.getPassword().equals(password)){
                user = userResult;
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
        return user;
    }

    public static int save(UserEntity user)
    {
        int result = 0;
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            session.save(user);
            trans.commit();
            result = 1;
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

    public static List get(int pageNumber, int pageSize)
    {
        List users = new ArrayList();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            Query countQuery = session.createQuery("select count(u.id) from UserEntity u");
            totalRow = (Long) countQuery.uniqueResult();
            totalPage = (int)(totalRow / pageSize);

            Query query = session.createQuery("from UserEntity ");
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            users = query.list();
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
        return users;
    }


    public static UserEntity find(int id)
    {
        UserEntity user = null;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            user = session.get(UserEntity.class, id);
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
        return user;
    }

    public static UserEntity getByEmail(String email)
    {
        UserEntity user = null;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from UserEntity where email=?");
            query.setParameter(0,email);
            user = (UserEntity) query.uniqueResult();
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
        return user;
    }

    public static UserEntity getByToken(String token)
    {
        UserEntity user = null;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from UserEntity where token=?");
            query.setParameter(0,token);
            user = (UserEntity) query.uniqueResult();
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
        return user;
    }

    public static int update(UserEntity user)
    {
        int result = 0;
        Transaction trans = null;
        Session session = getSession();

        try{
            trans = session.beginTransaction();
            session.update(user);
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

}
