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

@WebServlet(name = "updateUserServlet", value = "/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //TODO: Adapt this code to Edit User outside the Admin Interface
        String strId = request.getParameter("txt_id");
        String strLogin = request.getParameter("txt_login");
        String strPass = request.getParameter("txt_pass");
        String strPerm = request.getParameter("txt_perm");

        User logged = (User) request.getSession().getAttribute("User"); //Security checks

        User u = new User();
        // There is no Name in User Entity (small BUG on purpose)
        u.setID(Integer.parseInt(strId));
        u.setLogin(strLogin);
        u.setPassword(strPass);
        if(logged!=null && logged.getPermission()==User.ADMIN_PERMISSION) {
            //For security reasons, only Admins can set permission to Admin
            u.setPermission(Integer.parseInt(strPerm));
        }
        else{
            //Not Admin, therefore only allowed to set NORMAL permission
            u.setPermission(User.NORMAL_PERMISSION);
        }

        UserService.editUser(u);
        if(logged!=null && logged.getPermission()==User.ADMIN_PERMISSION) {
            //If Admin, it probably were on the CrudUser interface
            response.sendRedirect("admin/cruduser.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }

}