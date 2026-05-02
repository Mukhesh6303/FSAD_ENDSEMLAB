package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Library.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            // INSERT
            session.beginTransaction();
            Library lib = new Library("Java Book", "Core Java", new Date(), "Available");
            session.persist(lib);
            session.getTransaction().commit();

            System.out.println("Inserted: " + lib);

            // DELETE
            session.beginTransaction();
            session.remove(lib);
            session.getTransaction().commit();

            System.out.println("Deleted ID: " + lib.getId());
        } finally {
            session.close();
            factory.close();
        }
    }
}