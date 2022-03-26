/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Meron Seyoum
 */
public class UserService {

    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }

    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }

    public void insert(String email, boolean active, String first_name, String last_name, String password, Role role) throws Exception {
        User user = new User(email, active, first_name, last_name, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }

    public void update(String email, boolean active, String first_name, String last_name, String password, Role role) throws Exception {
        User user = new User(email, active, first_name, last_name, password, role);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }

    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}
