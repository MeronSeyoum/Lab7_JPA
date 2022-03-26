/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

/**
 *
 * @author Meron Seyoum
 */
public class RoleService {

    private RoleDB roleDB = new RoleDB();

    public List<Role> getAll() throws Exception {
        List<Role> roles = roleDB.getAll();
        return roles;
    }

}
