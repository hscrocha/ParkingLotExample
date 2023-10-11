package edu.loyola.cs.se.parkinglotexample.controller.servlet;

import static org.junit.jupiter.api.Assertions.*;

import edu.loyola.cs.se.parkinglotexample.model.dao.ContactDAO;
import edu.loyola.cs.se.parkinglotexample.model.entity.Contact;
import edu.loyola.cs.se.parkinglotexample.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MessageContactServletTest {

    @Test
    public void testProcessRequest() throws IOException {
        //Mocking
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("txt_name")).thenReturn("Name 1");
        when(request.getParameter("txt_email")).thenReturn("email@email.com");
        when(request.getParameter("txt_subject")).thenReturn("My Subject");
        when(request.getParameter("txt_message")).thenReturn("Message");

        ContactDAO mockdao = mock(ContactDAO.class);

        //Method Under test
        MessageContactServlet servlet = new MessageContactServlet();
        servlet.setDao(mockdao);
        servlet.doPost(request, response);

        //Assertions
        //AssertAll to make multiple assertions
        assertAll("MessageContactServlet - Normal Path Assertions",
                () -> assertDoesNotThrow( //AssertDoesNotThrow verifies no exception was thrown
                        () -> verify(response).sendRedirect("index.jsp"), //verify throws exception if method was not called
                        "MessageContactServlet should called sendRedirect(\"index.jsp\")"),
                () -> assertDoesNotThrow(
                        () -> verify(mockdao).create(any(Contact.class)),
                        "MessageContactServlet should called dao.create(...); ")
        );
    }

}
