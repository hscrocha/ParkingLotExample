package edu.loyola.cs.se.parkinglotexample.controller.service;

import edu.loyola.cs.se.parkinglotexample.model.dao.UserDAO;
import edu.loyola.cs.se.parkinglotexample.model.entity.User;
import edu.loyola.cs.se.parkinglotexample.util.PasswordUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*; //Mock Framework
import static org.junit.jupiter.api.Assertions.*;

/***
 * It is much more difficult to Mock static method calls
 * I only kept the methods here static to show how to test static methods
 * You should probably avoid static methods and turn these into normal methods for easier testing.
 *
 * If any student shows up seeking help with a similar Service
 * class with static methods, they will need a pretty good explaination
 * on why they are using static methods instead of normal ones.
 */
public class UserServiceTest {
    @Test public void testRegisterUser(){
        //Setup Data & Expected Return
        User registered = new User(101,"test@test.com",PasswordUtil.hash("123456"),User.NORMAL_PERMISSION);
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
        newUser.setPassword("123");

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

    @Test public void testLoginSuccessful(){
        //Setup Data & Expected returns
        String email = "test@test.com";
        String unhashed = "654321";
        String hashed = PasswordUtil.hash(unhashed);
        User answer = new User(101,email,hashed,User.NORMAL_PERMISSION);

        //We need to use Mocks to test the controller layer
        UserDAO mockDAO = mock(UserDAO.class);
        //ATTENTION: the mock part bellow is different for every test
        when(mockDAO.findUserByLogin(anyString())).thenReturn(answer);
        UserService.setDAO(mockDAO);

        //Method Under Test
        User logged = UserService.loginUser(email,unhashed);

        //Assertions (Finally)
        assertAll("Login User Service assertion",
            ()-> assertNotNull(logged,"Logged user cannot be null") ,
            ()-> assertEquals(logged.getID(), answer.getID())
        );
    }

    @Test public void testLoginFailurePasswordDotNotMatch(){
        //Setup Data & Expected returns
        String email = "test@test.com";
        String incorrectPass = "654321";
        String hashed = PasswordUtil.hash("123456");
        User answer = new User(101,email,hashed,User.NORMAL_PERMISSION);

        //We need to use Mocks to test the controller layer
        UserDAO mockDAO = mock(UserDAO.class);
        //ATTENTION: the mock part bellow is different for every test
        when(mockDAO.findUserByLogin(anyString())).thenReturn(answer);
        UserService.setDAO(mockDAO);

        //Method Under Test
        User logged = UserService.loginUser(email,incorrectPass);

        //Assertions (Finally)
        assertNull(logged,"Logged must be null if password is incorrect");
    }

    @Test public void testListUsers(){
        //We need to use Mocks to test the controller layer
        UserDAO mockDAO = mock(UserDAO.class);
        //ATTENTION: the mock part bellow is different for every test
        when(mockDAO.list(anyString())).thenReturn(new ArrayList<User>());
        UserService.setDAO(mockDAO);

        List<User> lst = UserService.listUsers("Login");
        assertNotNull(lst);
    }

    @Test public void smokeTestDeleteUser(){
        //We need to use Mocks to test the controller layer
        UserDAO mockDAO = mock(UserDAO.class);
        //ATTENTION: the mock part bellow is different for every test
        //doNothing().when(mockDAO).delete(anyInt()); //Not necessary
        UserService.setDAO(mockDAO);

        assertDoesNotThrow( ()-> UserService.deleteUser(1) );
    }

    @Test public void testEditUserNoPassword(){
        //Setup Data & Expected Return
        User registered = new User(101,"test@test.com",PasswordUtil.hash("123456"),User.NORMAL_PERMISSION);
        User updatedUser = new User(101,"test@test.com",null,User.NORMAL_PERMISSION);

        //We need to use Mocks to test the controller layer
        UserDAO mockDAO = mock(UserDAO.class);
        when(mockDAO.update(any(User.class))).thenReturn(registered);
        when(mockDAO.read(anyInt())).thenReturn(registered);
        UserService.setDAO(mockDAO);

        //Method Under Test
        User returned = UserService.editUser(updatedUser);

        //Assertions
        assertAll("Edit User Assertions -- No password",
                () -> assertEquals(returned.getID(),registered.getID(), "Updated User ID should be 101"),
                () -> assertEquals(returned.getPassword(), registered.getPassword(), "Updated User Password should be a hashed version from read()"),
                () -> assertDoesNotThrow(
                        () -> verify(mockDAO).read(eq(updatedUser.getID())),"editUser should have called dao.read(101)"
                ),
                () -> assertDoesNotThrow(
                    () -> verify(mockDAO).update(any(User.class)),"editUser should have called dao.update()"
                )
        );
    }

    @Test public void testEditUserWithPassword(){
        //Setup Data & Expected Return
        String unhashedPass = "123456";
        User updatedUser = new User(101,"test@test.com",unhashedPass,User.NORMAL_PERMISSION);

        //We need to use Mocks to test the controller layer
        UserDAO mockDAO = mock(UserDAO.class);
        when(mockDAO.update(any(User.class))).thenReturn(updatedUser);
        UserService.setDAO(mockDAO);

        //Method Under Test
        User returned = UserService.editUser(updatedUser);

        //Assertions
        assertAll("Edit User Assertions -- No password",
                () -> assertEquals(returned.getID(),updatedUser.getID(), "Updated User ID should be 101"),
                () -> assertNotEquals(returned.getPassword(), unhashedPass, "Returned User Password should be a hashed version from read()"),
                () -> assertDoesNotThrow(
                        () -> verify(mockDAO, never()).read(anyInt()),"editUser should never called dao.read() for a user with password"
                ),
                () -> assertDoesNotThrow(
                        () -> verify(mockDAO).update(any(User.class)),"editUser should have called dao.update()"
                )
        );
    }

}
