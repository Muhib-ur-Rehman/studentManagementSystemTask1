package com.example.StudentManagementSystemTask1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class searchForUpdate extends HttpServlet {
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
        Query query = session.createQuery("from Student2 where RollNum=:r");
        query.setParameter("r",Integer.parseInt(req.getParameter("rollNum")));
        ArrayList<Student2> listOfStudent = (ArrayList<Student2>) query.list();
        session.close();
        req.setAttribute("dataOfStudent",listOfStudent);
        RequestDispatcher rd;
        if (listOfStudent.size() > 0){
            rd = req.getRequestDispatcher("updateStudent.jsp");
        }
        else{
            rd = req.getRequestDispatcher("updateUI.jsp");
        }
        rd.forward(req,resp);
    }
}
