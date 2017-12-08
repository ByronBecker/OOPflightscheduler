package com.flight_scheduler;
//Modelled after http://www.codejava.net/frameworks/hibernate/building-hibernate-sessionfactory-from-service-registry hibernateUtil

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory session_factory;

    public static SessionFactory getSession_factory(){
        if (session_factory == null){
            Configuration config = new Configuration();
            session_factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
        }

        return session_factory;
    }
}
