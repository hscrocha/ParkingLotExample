package edu.loyola.cs.se.parkinglotexample.model.dao;

import edu.loyola.cs.se.parkinglotexample.model.entity.Contact;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactDAOTest {

    ContactDAO dao;
    @BeforeEach public void setup(){
        dao = new ContactDAO();
        dao.setDbTypeOutput(GenericDAO.DbType.TEST);
    }

    @AfterEach public void cleanup(){
        dao.deleteAll();
    }

    @Test
    public void testInsertion(){
        Contact c = new Contact();
        c.setMessage("test message");
        c.setSubject("subject1");
        c.setEmail("test@test.com");
        Contact saved = dao.create(c);
        Contact found = dao.read(saved.getID());

        assertAll(
                ()-> assertNotNull( saved.getID() ),
                ()-> assertEquals(found.getMessage(),saved.getMessage() )
        );
    }

    @Test public void testDelete(){
        Contact c = new Contact();
        c.setMessage("test message2323");
        c.setSubject("subject2");
        c.setEmail("test@test.co.uk");
        Contact saved = dao.create(c);
        dao.delete(saved.getID());
        Contact found = dao.read(saved.getID());

        assertNull( found );
    }
}
