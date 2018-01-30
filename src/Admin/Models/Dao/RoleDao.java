package Admin.Models.Dao;

import Admin.Models.Entities.RoleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Where;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tarek Monjur on 12/19/2017.
 */
public class RoleDao {

    private static SessionFactory sessionFactoryObj;
        public static int totalPage = 0;
        public static long totalRow = 0;

    private static SessionFactory getSessionFactory(){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sessionFactoryObj = cfg.buildSessionFactory();
        return sessionFactoryObj;
    }

    public static int save(RoleEntity Role)
    {
        int result = 0;
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();
            session.persist(Role);
            result = Role.getId();
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


    public static List<RoleEntity> all()
    {
        List<RoleEntity> roles = new ArrayList<>();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            roles = session.createQuery("from RoleEntity").list();
        }catch(Exception e){
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.flush();
                session.close();
            }
        }
        return roles;
    }


    public static List<RoleEntity> get(int pageNumber, int pageSize)
    {
        List<RoleEntity> roles = new ArrayList<>();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            Query countQuery = session.createQuery("select count(r.id) from RoleEntity r");
            totalRow = (Long) countQuery.uniqueResult();
            totalPage = (int) (totalRow / pageSize);

            Query query = session.createQuery("from RoleEntity order by id desc");
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            roles = query.list();
        }catch(Exception e){
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.flush();
                session.close();
            }
        }
        return roles;
    }


    public static RoleEntity find(int id)
    {
        RoleEntity role = null;
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            role = (RoleEntity) session.get(RoleEntity.class, id);
        }catch (Exception e){
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.flush();
                session.close();
            }
        }
        return role;
    }


    public static int update(RoleEntity role)
    {
        int result = 0;
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            session.update(role);
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


    public static int delete(int id)
    {
        int result = 0;
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            RoleEntity role = find(id);
            session.delete(role);
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

    public static List getRoleByCompanyId(int companyId)
    {
        List roles = new ArrayList<>();
        Transaction trans = null;
        Session session = getSessionFactory().openSession();

        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from RoleEntity where companyId=? order by id desc");
            query.setParameter(0,companyId);
            roles = query.list();
        }catch (Exception e){
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.flush();
                session.close();
            }
        }
        return roles;
    }

}
