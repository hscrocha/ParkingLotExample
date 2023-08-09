// SPDX-License-Identifier: MIT
package edu.loyola.cs.se.parkinglotexample.model.entity;

import javax.persistence.*;

@Entity
public class User extends BaseEntity {
    @Id @Column(name="id_user") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID = null;
    private String Login;
    private String Password;
    private int Permission;

    public User(){
    }

    public User(Integer ID, String login, String password, int permission) {
        this.ID = ID;
        Login = login;
        Password = password;
        Permission = permission;
    }

    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getPermission() {
        return Permission;
    }

    public void setPermission(int permission) {
        Permission = permission;
    }
}

/* SQL Creation Script
create table User(
   id_user int not null auto_increment,
   login varchar(50) not null,
   password varchar(50) not null,
   permission int default 1,
   constraint user_pk primary key(id_user)
);
 */