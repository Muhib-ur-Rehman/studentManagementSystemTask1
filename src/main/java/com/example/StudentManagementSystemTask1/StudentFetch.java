package com.example.StudentManagementSystemTask1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFetch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out =response.getWriter();
        out.println("<h1>Fetching students records</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student2> criteria = builder.createQuery(Student2.class);
        criteria.from(Student2.class);
        ArrayList<Student2> entityList = (ArrayList<Student2>) session.createQuery(criteria).getResultList();
        session.close();
        request.setAttribute("dataOfStudent",entityList);
        RequestDispatcher rd = request.getRequestDispatcher("viewStudent.jsp");
        rd.forward(request,response);
    }
}
