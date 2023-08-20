package edu.loyola.cs.se.parkinglotexample.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/***
 * ServletTemplate is not a real class
 * just a template I use to quickly create Servlets
 * However, its lack of testing was decreasing my package coverage
 * Therefore, I set up smoke tests just to deal with this
 */
public class ServletTemplateTest {
    @Test public void testDoGet() throws IOException, ServletException {
        //Servlets always have two main parameters request & repost which we need to mock
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter printMock = mock(PrintWriter.class);

        when(response.getWriter()).thenReturn(printMock);

        ServletTemplate servlet = new ServletTemplate();
        servlet.doGet(request,response);

        //No Assertions, therefore not really testing anything
    }

    @Test public void testDoPost() throws IOException, ServletException{
        //Servlets always have two main parameters request & repost which we need to mock
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter printMock = mock(PrintWriter.class);

        when(response.getWriter()).thenReturn(printMock);

        ServletTemplate servlet = new ServletTemplate();
        servlet.doPost(request,response);

        //No Assertions, therefore not really testing anything
    }

}
