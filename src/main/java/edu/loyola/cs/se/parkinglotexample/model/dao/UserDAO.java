package edu.loyola.cs.se.parkinglotexample.model.dao;

import edu.loyola.cs.se.parkinglotexample.model.entity.User;
import javax.persistence.EntityManager;

public class UserDAO extends GenericDAO<User> {

    public UserDAO(){
        super(User.class);
    }
    public UserDAO(DbType output){
        super(User.class, output);
    }

    @Override public User read(int id){
        EntityManager em = this.getEntityManager();
        User entity = em.find(User.class, id);
        em.close();
        return entity;
    }

   public static void main(String[] args){
        User u = new User();
        u.setLogin("test@test.com");
        u.setPermission(1);
        u.setPassword("111");

        //UserDAO dao = new UserDAO(DbType.TEST);
        //dao.create(u);
       System.out.println(User.class.getAnnotation(javax.persistence.Table.class).name());
    }//*/
}
