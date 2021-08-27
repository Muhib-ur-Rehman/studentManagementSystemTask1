package com.example.StudentManagementSystemTask1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con =null;
        Statement stmt=null;
        int result=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","123456");
            stmt=con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO `student` (`Name`, `Sex`, `RollNum`, `Age`, `courseId`) VALUES ('"+req.getParameter("name")+"', '"+req.getParameter("gender")+"', '"+req.getParameter("rollNum")+"', '"+req.getParameter("age")+"', '0')";
        try {
            result=stmt.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("resultOfAdd",result);
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req,resp);
//        resp.setContentType("text/html");
//        PrintWriter out =resp.getWriter();
//        out.println("<h1>result of add is "+result+"</h1>");
    }
}
