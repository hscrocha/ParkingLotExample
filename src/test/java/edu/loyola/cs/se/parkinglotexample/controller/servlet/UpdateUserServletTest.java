package edu.loyola.cs.se.parkinglotexample.controller.servlet;

import edu.loyola.cs.se.parkinglotexample.controller.service.UserService;
import edu.loyola.cs.se.parkinglotexample.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class UpdateUserServletTest {

    @Test public void testDoPostAdminEdit() throws IOException, ServletException {
        User loggedAdmin = new User(1,"admin","",User.ADMIN_PERMISSION);

        //Servlets always have two main parameters request & repost which we need to mock
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class); //In this case, also Session

        //Setup the mock "inputs" on request
        when(request.getParameter("txt_id")).thenReturn("201");
        when(request.getParameter("txt_login")).thenReturn("test@test.com");
        when(request.getParameter("txt_pass")).thenReturn("123456");
        when(request.getParameter("txt_perm")).thenReturn(Integer.toString(User.ADMIN_PERMISSION));
        when(request.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute("User")).thenReturn(loggedAdmin);

        //Also need to mock UserService, since it is static method, the mocking is different
        try (MockedStatic<UserService> service = mockStatic(UserService.class)) {
            //Inside try block, we can replace static method calls to UserService
            service.when(() -> UserService.editUser(any()) ).thenReturn(new User());

            UpdateUserServlet servlet = new UpdateUserServlet();
            servlet.doPost(request,response);

            assertAll("Update User -- Admin edit assertions",
                    ()-> assertDoesNotThrow(
                            () -> verify(sessionMock).getAttribute(eq("User")),
                            "UpdateUserServlet should have called session.getAttribute(\"User\") to verify Admin permission"),
                    ()-> assertDoesNotThrow(
                            () -> service.verify( ()-> UserService.editUser(any(User.class))) ,
                            "UpdateUserServlet should have called UserService.editUser(...)"),
                    ()-> assertDoesNotThrow(
                        () -> verify(response).sendRedirect("admin/cruduser.jsp"),
                        "UpdateUserServlet should called sendRedirect(\"admin/cruduser.jsp\")")
            );
        }
    }

    @Test public void testDoPostNotAdminEdit() throws IOException, ServletException {
        //Servlets always have two main parameters request & repost which we need to mock
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class); //In this case, also Session

        //Setup the mock "inputs" on request
        when(request.getParameter("txt_id")).thenReturn("201");
        when(request.getParameter("txt_login")).thenReturn("test@test.com");
        when(request.getParameter("txt_pass")).thenReturn("123456");
        when(request.getParameter("txt_perm")).thenReturn(Integer.toString(User.ADMIN_PERMISSION));
        when(request.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute("User")).thenReturn(null);

        //Also need to mock UserService, since it is static method, the mocking is different
        try (MockedStatic<UserService> service = mockStatic(UserService.class)) {
            //Inside try block, we can replace static method calls to UserService
            service.when(() -> UserService.editUser(any()) ).thenReturn(new User());

            UpdateUserServlet servlet = new UpdateUserServlet();
            servlet.doPost(request,response);

            assertAll("Update User -- Non-Admin edit assertions",
                    ()-> assertDoesNotThrow(
                            () -> verify(sessionMock).getAttribute(eq("User")),
                            "UpdateUserServlet should have called session.getAttribute(\"User\") to verify Admin permission"),
                    ()-> assertDoesNotThrow(
                            () -> service.verify( ()-> UserService.editUser(any(User.class))) ,
                            "UpdateUserServlet should have called UserService.editUser(...)"),
                    ()-> assertDoesNotThrow(
                            () -> verify(response).sendRedirect("index.jsp"),
                            "UpdateUserServlet should called sendRedirect(\"index.jsp\")")
            );
        }
    }
}
