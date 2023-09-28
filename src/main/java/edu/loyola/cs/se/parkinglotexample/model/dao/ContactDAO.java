package edu.loyola.cs.se.parkinglotexample.model.dao;

import edu.loyola.cs.se.parkinglotexample.model.entity.Contact;

public class ContactDAO extends GenericDAO<Contact>{

    /***
     * Default Constructor, it requires a BaseEntity subclass as Entity.class
     * Since GenericDAO is an abstract class you cannot instantiate by itself (this is by design and not a bug)
     * the goal is to enforce developers to create a subclas of GenericDAO
     * @param entityclass
     */
    public ContactDAO(Class<Contact> entityclass) {
        super(entityclass);
    }
}
