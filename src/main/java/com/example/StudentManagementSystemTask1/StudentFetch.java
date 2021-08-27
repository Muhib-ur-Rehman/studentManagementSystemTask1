package com.example.StudentManagementSystemTask1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class StudentFetch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out =response.getWriter();
        out.println("<h1>Fetching students records</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con =null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","123456");
            stmt=con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        String query = "Select * from student";
        ArrayList<Student> listOfStudent= new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                listOfStudent.add(new Student(Integer.parseInt( rs.getString(1)),rs.getString(2),Integer.parseInt(rs.getString(4)),Integer.parseInt(rs.getString(5)),rs.getString(3)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("dataOfStudent",listOfStudent);
        RequestDispatcher rd = request.getRequestDispatcher("viewStudent.jsp");
        rd.forward(request,response);


    }
}
