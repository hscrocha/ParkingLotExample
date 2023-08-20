package edu.loyola.cs.se.parkinglotexample.controller.servlet;

import edu.loyola.cs.se.parkinglotexample.controller.service.UserService;
import edu.loyola.cs.se.parkinglotexample.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.exceptions.verification.WantedButNotInvoked;

import java.io.IOException;

import static org.mockito.Mockito.*; //Mock Framework
import static org.junit.jupiter.api.Assertions.*;

public class RegisterUserServletTest {

    @Test public void testDoPostNormalPath() throws IOException, ServletException {
        //Servlets always have two main parameters request & repost which we need to mock
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        //Setup the mock "inputs" on request
        when(request.getParameter("txt_name")).thenReturn("TestName");
        when(request.getParameter("txt_login")).thenReturn("test@test.com");
        when(request.getParameter("txt_pass")).thenReturn("123456");

        //Setup the mock "outputs" on response
        doNothing().when(response).sendRedirect(anyString());

        //Also need to mock UserService, since it is static method, the mocking is different
        try (MockedStatic<UserService> service = mockStatic(UserService.class)) {
            //Inside try block, we can replace static method calls to UserService
            service.when(() -> UserService.registerUser(any()) ).thenReturn(new User());

            RegisterUserServlet servlet = new RegisterUserServlet();
            servlet.doPost(request,response);

            assertDoesNotThrow(
                    () -> verify(response).sendRedirect("user/registrationsuccess.jsp"),
                    "RegisterUserServlet should called sendRedirect(\"user/registrationsuccess.jsp\")");
        }
    }

    @Test public void testDoPostAlternativePath() throws IOException, ServletException {
        //Servlets always have two main parameters request & repost which we need to mock
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        //Setup the mock "inputs" on request
        when(request.getParameter("txt_name")).thenReturn("TestName");
        when(request.getParameter("txt_login")).thenReturn("test@test.com");
        when(request.getParameter("txt_pass")).thenReturn("123456");

        //Setup the mock "outputs" on response
        doNothing().when(response).sendRedirect(anyString());

        //Also need to mock UserService, since it is static method, the mocking is different
        try (MockedStatic<UserService> service = mockStatic(UserService.class)) {
            //Inside try block, we can replace static method calls to UserService
            service.when(() -> UserService.registerUser(any()) ).thenReturn(null);

            RegisterUserServlet servlet = new RegisterUserServlet();
            servlet.doPost(request,response);

            assertDoesNotThrow(
                    () -> verify(response).sendRedirect("register.jsp?error=1"),
                    "RegisterUserServlet should called sendRedirect(\"register.jsp?error=1\")");
        }
    }
}
