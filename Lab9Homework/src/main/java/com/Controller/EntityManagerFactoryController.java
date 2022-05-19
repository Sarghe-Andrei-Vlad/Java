package com.Controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryController {
    private static EntityManagerFactory emf = null;

    public EntityManagerFactoryController (){}

    public static EntityManagerFactory getEntityManagerFactory ()
    {
        if (emf==null || !emf.isOpen())
            createEntityManagerFactory();
        return emf;
    }

    private static void createEntityManagerFactory ()
    {
        emf=Persistence.createEntityManagerFactory("LAB9");
    }

    private static void closeEntityManagerFactory()
    {
        emf.close();
    }


}
