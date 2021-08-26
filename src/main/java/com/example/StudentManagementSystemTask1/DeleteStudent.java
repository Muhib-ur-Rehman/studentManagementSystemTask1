package com.example.StudentManagementSystemTask1;

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
        Connection con =null;
        PreparedStatement stmt=null;
        int result=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","123456");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        String query = "DELETE FROM student WHERE (`RollNum` = ?)";
        try {
            stmt=con.prepareStatement(query);
            stmt.setInt(1,Integer.parseInt(req.getParameter("rollNum")));
            result=stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("resultOfAdd",result);
        RequestDispatcher rd = req.getRequestDispatcher("deleteUI.jsp");
        rd.forward(req,resp);
    }
}
