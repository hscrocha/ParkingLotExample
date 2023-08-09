// SPDX-License-Identifier: MIT
package edu.loyola.cs.se.parkinglotexample.model.dao;

import edu.loyola.cs.se.parkinglotexample.model.entity.User;

/***
 * UserDAO is a subclass of GenericDAO
 * It is a good practice to extend GenericDAO for each specific entity
 * Then we can add custom methods for this DAO (mostly, custom list operations)
 */
public class UserDAO extends GenericDAO<User> {

    public UserDAO(){
        super(User.class);
    }

}
