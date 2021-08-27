package com.example.StudentManagementSystemTask1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class AddStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con =null;
        PreparedStatement stmt=null;
        int result=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","123456");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO `student` (`Name`, `Sex`, `RollNum`, `Age`, `courseId`) VALUES (?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1,req.getParameter("name"));
            stmt.setString(2,req.getParameter("gender"));
            stmt.setInt(3,Integer.parseInt(req.getParameter("rollNum")));
            stmt.setInt(4,Integer.parseInt(req.getParameter("age")));
            stmt.setInt(5,0);


            result=stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("resultOfAdd",result);
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req,resp);
    }
}
