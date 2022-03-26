<%-- 
    Document   : users
    Created on : 8-Mar-2022, 6:28:08 PM
    Author     : Meron Seyoum
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"   type="text/css" href="Style/User.css">
        <title>Manage Users</title>
        <script>
            function unhideAddUser()
            {
                document.getElementById('edit').style = "display: none;";
                document.getElementById('add').style = "display: block;";
            }
            function unhideEditUser()
            {
                var url = window.location.href;
                if (url !== "http://localhost:8080/User" || url !== "http://127.0.0.1:8080/User")
                {
                    document.getElementById('add').style = "display: none;";
                    document.getElementById('edit').style = "display: block;";
                }
            }
        </script>
    </head>
    <body onLoad='unhideEditUser()'>
   <%-- Add user in a database one at a time--%>   
        <div  class="main">  
            <div class="inner">
              <div class="msg" > ${message}  </div> 
              <h1>Manage Users</h1> 
               
                <button type="submit" onClick='unhideAddUser()'>Create A New User</button>
              
                <%-- form to add new users--%>
                <div style='display: none;' id="add" class="add">
                    <h2>Add New User</h2>
                    <form action="User" method="post">    
                        <label for="email"> Email</label> 
                        <input type="text" name="email" value="" required><br>
                        <label for="First_name"> First Name</label> 
                        <input type="text" name="first_name" value="" required><br>
                        <label for="last_name"> Last Name</label> 
                        <input type="text" name="last_name" value="" required><br>
                        <label for="password"> password</label> 
                        <input type="text" name="password" value="" required><br>
                        <label for="active"> Active</label>
                        <input type="checkbox" name="active" value="1" checked>
                        <br><br>
                        <label for="email"> role</label> 
                        <Select id="role" name="role">
                            <option value="1">System Admin</option>
                            <option value="2">Regular User</option>
                            <option value="3">Company Admin</option>
                        </Select><br>
                        <button type="submit" name="action" value="add"> Add User</button>
                        <button type="submit" name="action" value="cancle" class="canc">Cancel</button>
                    </form>
                </div>

                <%-- display all user in a table--%>   
                <table>
                    <thead>
                        <tr>
                            <th>Email</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>active</th>
                            <th>Role</th>
                            <th colspan=2>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td><c:out value="${user.email}" /></td>
                                <td><c:out value="${user.first_name}" /></td>
                                <td><c:out value="${user.last_name}" /></td>
                                <td><c:out value="${(user.active == 'True') ? 'Y' : 'N'}" /></td>
                                <td><c:out value="${user.getRole().getRole_name()}" /></td>
                                <td><a href="User?action=viewEdit&amp;email=${user.email.replace("+","%2B")}" >Edit</a></td>                           
                                <td><a href="User?action=delete&email=${user.email.replace("+","%2B")}">Delete</a></td>                              
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                 
                
              
                 <%-- form to edit existing users--%>
                <div style='display: none;' id="edit">
                    <form action="User" method="post">
                        <c:if test="${selectedUser ne null}">
                            <h2>Edit User</h2> 
                            <label for="email"> Email</label> 
                            <input type="text" name="email" value="${selectedUser.email}" readonly><br>
                            <label for="First_name"> First Name</label> 
                            <input type="text" name="first_name" value="${selectedUser.first_name}" required><br>
                            <label for="last_name"> Last Name</label> 
                            <input type="text" name="last_name" value="${selectedUser.last_name}" required><br>
                            <label for="password"> password</label> 
                            <input type="text" name="password" value="${selectedUser.password}" required><br>
                            <label for="active"> Active</label>                           
                            <c:choose>
                                <c:when test="${selectedUser.active eq 'True'}">
                                    <input type="checkbox" name="active"  checked> 
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="active" >
                                </c:otherwise>
                            </c:choose>
                            <br><br>
                            <label for="email"> role</label> 
                            <Select id="role" name="role">
                                <option value="1">System Admin</option>
                                <option value="2">Regular User</option>
                                <option value="3">Company Admin</option>
                            </Select><br>

                            <button type="submit" name="action" value="edit" id="editButton">Edit User</button> 
                            <button type="submit" name="action" value="delete" id="deleteButton" class="del">Delete</button>
                            <button type="submit" name="action" value="cancle" class="canc">Cancel</button>
                        </c:if> 
                    </form>
                </div>
                
            </div>
        </div>
    </body>
</html>
