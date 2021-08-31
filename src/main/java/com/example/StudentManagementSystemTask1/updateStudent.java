package com.example.StudentManagementSystemTask1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class updateStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Student2 std = new Student2();
        std.setStudentId(Integer.parseInt(req.getParameter("studentId")));
        std.setName(req.getParameter("name"));
        std.setAge(Integer.parseInt(req.getParameter("age")));
        std.setRollNum(Integer.parseInt(req.getParameter("rollNum")));
        std.setSex(req.getParameter("gender"));
        String courseArr[] = req.getParameterValues("course");
        ArrayList<Course> listOfCourse =new ArrayList<>();
        for (int i = 0 ; i<courseArr.length;i++){
            Course c = new Course();
            c.setCourseId(Integer.parseInt(courseArr[i]));
            listOfCourse.add(c);
        }
        std.setCourses(listOfCourse);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(std);
        tx.commit();
        session.close();
        req.setAttribute("resultOfAdd",1);
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req,resp);
    }
}
