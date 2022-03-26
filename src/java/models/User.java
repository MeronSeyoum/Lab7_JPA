/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package models;


import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Meron Seyoum
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "Select u from User u"),
})
public class User implements Serializable {
    @Id
    @Basic(optional = false)
    @Column
    private String email;
    @Column
    private boolean active;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column
    private String password;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role", referencedColumnName = "role_id")
    private Role role;

    public User(String email, boolean active, String first_name, String last_name, String password, Role role) {
        this.email = email;
        this.active = active;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
}
