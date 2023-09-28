package edu.loyola.cs.se.parkinglotexample.model.entity;

import javax.persistence.*;

@Entity
public class Contact extends BaseEntity{
    @Id @Column(name="id_contact") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Name;
    private String Email;
    private String Subject;
    private String Message;

    @Override
    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}

/**
-- SQL Statement for Creating the table
 create table contact(
    id_contact int not null auto_increment,
    name varchar(50) not null,
    email varchar(30),
    subject varchar(30),
    message varchar(1024),
    constraint contact_pk primary key(id_contact)
 );
 */
