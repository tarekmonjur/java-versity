package Admin.Services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by Tarek Monjur on 12/21/2017.
 */
public abstract class HibernateDatabase {

    private static SessionFactory sessionFactory;
    private static Session session;

    protected static SessionFactory getSessionFactory(){
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
        return sessionFactory;
    }

    protected static Session getSession(){
        session = getSessionFactory().openSession();
        return session;
    }
}
