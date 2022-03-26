/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package dataaccess;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import models.Role;

/**
 *
 * @author Meron Seyoum
 */
public class RoleDB {
    
 public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Query query = em.createNamedQuery("Role.findAll");
            return query.getResultList();
        } finally {
            em.close();
        } 
    }  
}
