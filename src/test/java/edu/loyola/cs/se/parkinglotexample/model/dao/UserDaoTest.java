package edu.loyola.cs.se.parkinglotexample.model.dao;

import edu.loyola.cs.se.parkinglotexample.model.entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    public static UserDAO dao = null;

    public static User createNewUserEntity(){
        User u = new User();
        u.setLogin("test@test.com");
        u.setPermission(1);
        u.setPassword("111");
        return u;
    }

    @BeforeAll public static void createDao(){
        dao = new UserDAO(GenericDAO.DbType.TEST);
    }

    @BeforeEach public void deleteAll(){
        dao.deleteAll();
    }

    @AfterAll public static void deleteAllAfter(){
        dao.deleteAll();
    }

    @Test public void testCreateUser(){
        User newuser = createNewUserEntity();

        dao.create(newuser);
        User found = dao.read(newuser);
        assertAll("Grouped Assertions of Create User",
                () -> assertNotNull(newuser.getID(), "ID should not be null after creation"),
                () -> assertNotNull(found, "Found user after reading should not be null"),
                () -> assertEquals(newuser.getLogin(), found.getLogin(), "Login for the newuser must be equal to the Login for the found user")
                );
    }

    @Test public void testDeleteUserById(){
        User newuser = createNewUserEntity();
        dao.create(newuser);
        dao.delete(newuser.getID());
        User found = dao.read(newuser);
        assertNull(found, "User cannot be in the DB after deletion");
    }

    @Test public void smokeTestDeleteWhatDoesNotExists(){
        //Smoke test has no assertion, we are only testing if this does not raise any exceptions
        User notsaved = createNewUserEntity();
        dao.delete(notsaved);
    }

    @Test public void testUpdateUser(){
        User newuser = createNewUserEntity();
        String newlogin = "Altered";
        dao.create(newuser);
        newuser.setLogin(newlogin);
        User updated = dao.update(newuser);
        User found = dao.read(newuser);
        assertAll("Grouped Assertions of Updated User",
                () -> assertEquals(updated.getLogin(),newlogin),
                () -> assertEquals(updated.getID(), found.getID()),
                () -> assertEquals(updated.getLogin(),found.getLogin()),
                () -> assertEquals(updated.getPermission(),found.getPermission())
            );
    }

}
