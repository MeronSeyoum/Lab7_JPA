/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.UserService;

/**
 *
 * @author Meron Seyoum
 */
public class UserServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userservice = new UserService();

        try {
            List<User> users = userservice.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
        }

        String action = request.getParameter("action");
        if (action != null && (action.equals("viewEdit") || action.equals("delete"))) {
            try {
                String email = request.getParameter("email");
                User user = userservice.get(email);
                request.setAttribute("selectedUser", user);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userservice = new UserService();
        // RoleService roleservice = new RoleService();
        Role roles = null;
// parameters from the input text as a string
        String actions = request.getParameter("action");
        String email = request.getParameter("email");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String password = request.getParameter("password");
        String active = (request.getParameter("active") == null ? "false" : "true");
        int role_id = Integer.parseInt(request.getParameter("role"));

// find the role id as object for role
        try {
            roles = new Role(role_id);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
// using the if conditon manipulate the data using CRUD operation
        if (actions.equals("add")) {
            try {
                userservice.insert(email, Boolean.parseBoolean(active), first_name, last_name, password, roles);
                request.setAttribute("message", "User " + first_name + " has Successfully Added");
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (actions.equals("edit")) {
            try {
                userservice.update(email, Boolean.parseBoolean(active), first_name, last_name, password, roles);
                request.setAttribute("message", "User " + first_name + " has been Successfully Updated");
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (actions.equals("delete")) {

            try {
                userservice.delete(email);
                request.setAttribute("message", "User " + first_name + " has been deleted.");

            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (actions.equals("cancle")){
// on cancle redirect to view
            try {
                List<User> users = userservice.getAll();
                request.setAttribute("users", users);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("message", ex);
            }
        }
// after any CRUD operation view all data including the updated data
        try {
            List<User> users = userservice.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex);
        }
// finally diplay user jsp 
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}
