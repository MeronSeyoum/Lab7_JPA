/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Meron Seyoum
 */
@Entity
@Table(name="role")
@NamedQueries({
    @NamedQuery(name="Role.findAll", query = "Select r from Role r")   
    })
public class Role implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name="role_id")
    private int role_id;

    @Column(name="role_name")
    private String role_name;

    @OneToMany
    private List<User> user;

    public Role() {
    }

    public Role(int role_id, String role_name, List<User> user) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.user = user;
    }

    public Role(int role_id) {
        this.role_id = role_id;

    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

}
