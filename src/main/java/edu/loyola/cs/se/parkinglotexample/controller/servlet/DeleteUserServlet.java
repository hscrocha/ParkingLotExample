// SPDX-License-Identifier: MIT
package edu.loyola.cs.se.parkinglotexample.controller.servlet;

import edu.loyola.cs.se.parkinglotexample.controller.service.UserService;
import edu.loyola.cs.se.parkinglotexample.model.entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteUserServlet", value = "/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));

        User logged = (User) request.getSession().getAttribute("User");
        //For security reasons, only Admins can delete other users
        if(logged!=null && logged.getPermission()==User.ADMIN_PERMISSION){
            UserService.deleteUser(id);
            response.sendRedirect("admin/cruduser.jsp");
        }
        else{
            //Access Denied
            response.sendRedirect("index.jsp");
        }
        //We may adapt this servlet later so that a User can delete itself even if not admin
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }

}