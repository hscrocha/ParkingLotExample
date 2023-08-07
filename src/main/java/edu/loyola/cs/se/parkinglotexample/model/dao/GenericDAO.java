package edu.loyola.cs.se.parkinglotexample.model.dao;

import edu.loyola.cs.se.parkinglotexample.model.entity.BaseEntity;
import edu.loyola.cs.se.parkinglotexample.model.entity.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.annotation.Annotation;

public abstract class GenericDAO<E extends BaseEntity> {
    public enum DbType {STANDARD, TEST};
    protected static EntityManagerFactory standardEMF = null;
    protected static EntityManagerFactory testEMF = null;

    protected DbType DbTypeOutput = DbType.STANDARD;
    protected Class<E> EntityClass;
    public GenericDAO(Class<E> entityclass, DbType output){
        this.EntityClass = entityclass;
        this.DbTypeOutput = output;
    }
    public GenericDAO(Class<E> entityclass){
        this(entityclass, DbType.STANDARD);
    }

    protected EntityManager getEntityManager(){
        EntityManagerFactory fac = null;
        switch (DbTypeOutput){
            case STANDARD:
                if(standardEMF == null) standardEMF = Persistence.createEntityManagerFactory("standardPersistenceUnit");
                fac = standardEMF;
                break;
            case TEST:
                if(testEMF == null) testEMF = Persistence.createEntityManagerFactory("testPersistenceUnit");
                fac = testEMF;
                break;
        }
        return fac.createEntityManager();
    }

    public void create(E entity){
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public E read(E entity){
        return read(entity.getID());
    }

    public E read(int id){
        EntityManager em = this.getEntityManager();
        E entity = em.find(EntityClass, id);
        em.close();
        return entity;
    }

    public E update(E entity){
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        E updated = em.merge(entity);
        em.getTransaction().commit();
        return updated;
    }

    public void delete(int id){
        E entity = read(id);
        delete(entity);
    }
    public void delete(E entity){
        if(entity!=null && entity.getID()!=null) {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            E mergedContext = em.merge(entity);
            em.remove(mergedContext);
            em.getTransaction().commit();
        }
    }

    /**
     * Delete All records in the table.
     * This should *not* be used in Production DB only for TestDB
     */
    public void deleteAll(){
        if(DbTypeOutput==DbType.TEST) {
            String query;
            javax.persistence.Table tableannotation = EntityClass.getAnnotation(javax.persistence.Table.class);
            if (tableannotation != null) query = "DELETE FROM " + tableannotation.name();
            else query = "DELETE FROM " + EntityClass.getName();

            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.createQuery(query).executeUpdate();
            em.getTransaction().commit();
        } else {
            System.out.println("Access Denied, cannot use deleteAll outside testing.");
        }
    }
}
