package edu.loyola.cs.se.parkinglotexample.controller.service;

import edu.loyola.cs.se.parkinglotexample.model.dao.UserDAO;
import edu.loyola.cs.se.parkinglotexample.model.entity.User;
import edu.loyola.cs.se.parkinglotexample.util.PasswordUtil;

public class UserService {

    public static UserDAO dao = new UserDAO();

    public static void setDAO(UserDAO dao){
        UserService.dao = dao;
    }

    public static User registerUser(User newUser){

        try {
            newUser = dao.create(newUser);
        }catch(javax.persistence.PersistenceException ex){
            //Repeated login
            newUser = null;
            System.out.println(ex);
        }
        finally {
            return newUser;
        }
    }

    public static void loginUser(String login, String password){

    }
}
