package com.example.StudentManagementSystemTask1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class SearchStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con =null;
        PreparedStatement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","123456");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
//        String query = "Select * from student where RollNum="+req.getParameter("rollNum");
        String query = "Select * from student where RollNum= ? ";
        ArrayList<Student> listOfStudent= new ArrayList<>();
        try {
            stmt=con.prepareStatement(query);
            stmt.setInt(1,Integer.parseInt(req.getParameter("rollNum")));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                listOfStudent.add(new Student(Integer.parseInt( rs.getString(1)),rs.getString(2),Integer.parseInt(rs.getString(4)),Integer.parseInt(rs.getString(5)),rs.getString(3)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("dataOfStudent",listOfStudent);
        RequestDispatcher rd = req.getRequestDispatcher("searchUI.jsp");
        rd.forward(req,resp);
    }
}
