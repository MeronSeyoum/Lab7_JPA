/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author merya
 */
public class DBUtil  {
 private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("UsersPU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
