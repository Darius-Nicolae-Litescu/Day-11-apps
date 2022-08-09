package darius.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

    private SessionFactory factory;

    public SessionFactoryUtil() {
    }

    public void initializeFactory() {
        System.out.println("------------- Static block start -------------");
        Configuration cfg = new Configuration();
        this.factory = cfg.configure().buildSessionFactory();
        System.out.println("------------- Static block end -------------");
    }

    public SessionFactory getFactory() {
        return factory;
    }


}