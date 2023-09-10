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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class DeleteUserServletTest {

    @Test public void testAdminDeletion() throws IOException {
        User adminUser = new User();
        adminUser.setID(101);
        adminUser.setLogin("test@test.com");
        adminUser.setPermission(User.ADMIN_PERMISSION);
        Integer idToDelete = 10;

        //Servlets always have two main parameters request & repost which we need to mock
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class); //In this case, also Session

        //Setup the mock "inputs" on request
        when(request.getParameter("id")).thenReturn(idToDelete.toString());
        when(request.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute("User")).thenReturn(adminUser);

        //Also need to mock UserService, since it is static method, the mocking is different
        try (MockedStatic<UserService> service = mockStatic(UserService.class)) {
            //Inside try block, we replace static method calls to UserService
            DeleteUserServlet servlet = new DeleteUserServlet();
            servlet.doPost(request, response);

            assertAll("DeleteUserServlet - Logged Admin Path Assertions",
                    () -> assertDoesNotThrow(
                            () -> service.verify(() -> UserService.deleteUser(idToDelete)),
                            "DeleteUserServlet should called UserService.deleteUser("+idToDelete+")"),
                    () -> assertDoesNotThrow(
                            () -> verify(response).sendRedirect("admin/cruduser.jsp"),
                            "DeleteUserServlet should called sendRedirect(\"admin/cruduser.jsp\")")
            );
        }
    }

    @Test public void testNotAdminDeletion() throws IOException{
        //Servlets always have two main parameters request & repost which we need to mock
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class); //In this case, also Session

        //Setup the mock "inputs" on request
        when(request.getParameter("id")).thenReturn("101");
        when(request.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute("User")).thenReturn(null);

        //Also need to mock UserService, since it is static method, the mocking is different
        try (MockedStatic<UserService> service = mockStatic(UserService.class)) {
            //Inside try block, we replace static method calls to UserService
            DeleteUserServlet servlet = new DeleteUserServlet();
            servlet.doGet(request, response);

            assertAll("DeleteUserServlet - Not Logged Path Assertions",
                    () -> assertDoesNotThrow(
                            () -> service.verify(()-> UserService.deleteUser(101), never()),
                            "DeleteUserServlet should never call UserService.deleteUser() for non-admin"),
                    () -> assertDoesNotThrow(
                            () -> verify(response).sendRedirect("index.jsp"),
                            "DeleteUserServlet should called sendRedirect(\"index.jsp\")")
            );
        }

    }
}
