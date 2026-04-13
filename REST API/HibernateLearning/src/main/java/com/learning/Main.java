package com.learning;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Alien a1 = new Alien();
        a1.setAid(104);
        a1.setName("Sumit");
        a1.setTech("Database");

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.learning.Alien.class);
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

//        <____________INSERTION OF DATA ______________>
//        Transaction transaction = session.beginTransaction(); // it is not needed while fetching the Information
//        session.persist(a1); //for writing into DB
//        transaction.commit();


//        <________________FETCHING THE DATA ________________>
//        Alien alien = session.find(Alien.class,103);
//        System.out.println(alien);

//        <________________________UPDATING THE DATA_____________>
//        if record not find it will create a new one
//        Transaction transaction = session.beginTransaction();
//        session.merge(a1);
//        transaction.commit();

//        <____________________DELETE THE DATA___________________>
        Transaction transaction = session.beginTransaction();
        Alien alien = session.find(Alien.class, 103);
        session.remove(alien);
        transaction.commit();



        session.close();
        factory.close();
    }
}