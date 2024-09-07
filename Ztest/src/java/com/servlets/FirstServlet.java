package com.servlets;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * A simple servlet example.
 * 
 * @author Tanmay Gupta
 */
public class FirstServlet implements Servlet {
    private ServletConfig conf;
    public static void main(String args []){
        
    }
    @Override
    public void init(ServletConfig conf) throws ServletException {
        this.conf = conf;
        System.out.println("Creating object: ...");
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("Servicing ................");
        PrintWriter out = resp.getWriter();
        var date = new Date();
        out.println("<h1>"+ date + "</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("Going to destroy servlet object");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.conf;
    }

    @Override
    public String getServletInfo() {
        return "This servlet is created by Tanmay Gupta";
    }
}
