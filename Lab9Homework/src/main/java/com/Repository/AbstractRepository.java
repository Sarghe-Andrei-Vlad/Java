package com.Repository;

import com.Controller.EntityManagerFactoryController;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractRepository <O extends Object> {

    private EntityManager em = EntityManagerFactoryController.getEntityManagerFactory().createEntityManager();
    private final Class<O> type;
    private final Logger logger;

    public AbstractRepository(Class<O> type) {
        this.type = type;
        logger = Logger.getLogger(type.getName());
    }

    public void create (O object){
            Long start=System.currentTimeMillis();
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            Long result=System.currentTimeMillis()-start;
            logger.info(logger.getName()+"\nTime for insertion is: " +result+" ms.\n");
    }
    public O findById(Integer id)
    {
        return em.find(type,id);
    }
    public List<O> findByName (String name)
    {
        List<O> result = new ArrayList<>();
        String className = type.getSimpleName();
        try {
            result= em.createNamedQuery(className+".findByName").setParameter("name",name).getResultList();
        }
        catch (NoResultException e)
        {
            System.out.println("Nu a fost gasit niciun "+className+" cu numele " + name+".");
        }
        return result;
    }
}
