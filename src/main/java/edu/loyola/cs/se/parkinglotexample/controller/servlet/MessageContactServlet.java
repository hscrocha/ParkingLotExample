// SPDX-License-Identifier: MIT
package edu.loyola.cs.se.parkinglotexample.controller.servlet;

import edu.loyola.cs.se.parkinglotexample.model.dao.ContactDAO;
import edu.loyola.cs.se.parkinglotexample.model.entity.Contact;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "messageContactServlet", value = "/messageContactServlet")
public class MessageContactServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String name = request.getParameter("txt_name");
        String email = request.getParameter("txt_email");
        String subject = request.getParameter("txt_subject");
        String message = request.getParameter("txt_message");

        Contact c = new Contact();
        c.setName(name);
        c.setEmail(email);
        c.setSubject(subject);
        c.setMessage(message);

        ContactDAO dao = new ContactDAO();
        dao.create(c);

        response.sendRedirect("index.jsp");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);
    }

}