package com.example.StudentManagementSystemTask1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class DeleteStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("delete from Student2 where RollNum=:r");
        query.setParameter("r",Integer.parseInt(req.getParameter("rollNum")));
        Transaction tx = session.beginTransaction();
        int result = query.executeUpdate();
        tx.commit();
        req.setAttribute("resultOfAdd",result);
        RequestDispatcher rd = req.getRequestDispatcher("deleteUI.jsp");
        rd.forward(req,resp);
    }
}
