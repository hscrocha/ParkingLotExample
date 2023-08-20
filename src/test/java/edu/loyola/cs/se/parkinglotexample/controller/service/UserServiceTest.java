package edu.loyola.cs.se.parkinglotexample.controller.service;

import edu.loyola.cs.se.parkinglotexample.model.dao.UserDAO;
import edu.loyola.cs.se.parkinglotexample.model.entity.User;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*; //Mock Framework
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    @Test public void testRegisterUser(){
        //Setup Data & Expected Return
        User registered = new User(101,"test@test.com","123456",User.NORMAL_PERMISSION);
        User newUser = new User(null,"test@test.com","123456",User.NORMAL_PERMISSION);

        //We need to use Mocks to test the controller layer
        UserDAO mockDAO = mock(UserDAO.class);
        when(mockDAO.create(any(User.class))).thenReturn(registered);
        UserService.setDAO(mockDAO);

        //Method Under Test
        User returned = UserService.registerUser(newUser);

        //Assertions
        assertAll("Register User Service Assertions",
                () -> assertEquals(returned.getID(),registered.getID(), "Registered ID should be 101"),
                () -> assertEquals(returned.getLogin(), registered.getLogin(), "Registered Login should be test@test.com")
        );
    }

    @Test public void testRegisteredUserCatchingException(){
        User newUser = new User();

        //We need to use Mocks to test the controller layer
        UserDAO mockDAO = mock(UserDAO.class);
        //ATTENTION: the mock part bellow is different - I am forcing the method to always throw an exception
        when(mockDAO.create(any(User.class))).thenThrow(new javax.persistence.PersistenceException("Test Exception"));
        UserService.setDAO(mockDAO);

        //Method Under Test
        User returned = UserService.registerUser(newUser);

        //Since the Exception is caught inside the method, we can test the return
        assertNull(returned, "Returned user should be null if Login exists (exception).");
    }

}
