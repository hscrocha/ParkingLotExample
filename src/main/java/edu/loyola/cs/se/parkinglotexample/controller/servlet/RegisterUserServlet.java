// SPDX-License-Identifier: MIT
package edu.loyola.cs.se.parkinglotexample.controller.servlet;

import java.io.*;

import edu.loyola.cs.se.parkinglotexample.controller.service.UserService;
import edu.loyola.cs.se.parkinglotexample.model.entity.User;
import edu.loyola.cs.se.parkinglotexample.util.PasswordUtil;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "registerUserServlet", value = "/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strName = request.getParameter("txt_name");
        String strLogin = request.getParameter("txt_login");
        String strPass = request.getParameter("txt_pass");

        User newUser = new User();
        // There is no Name in User Entity (small BUG on purpose)
        newUser.setLogin(strLogin);
        newUser.setPassword(PasswordUtil.hash(strPass));

        User registered = UserService.registerUser(newUser);
        if(registered==null) {
            response.sendRedirect("register.jsp?error=1");
        } else {
            response.sendRedirect("user/registrationsuccess.jsp");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }

}