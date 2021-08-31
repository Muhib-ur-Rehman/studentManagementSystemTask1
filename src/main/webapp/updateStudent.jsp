<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.StudentManagementSystemTask1.Student2" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: mrehman
  Date: 31/08/2021
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    <title>Title</title>
</head>
<body>
    <%
        ArrayList<Student2> listOfStudent = (ArrayList<Student2>) request.getAttribute("dataOfStudent");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","123456");
        String query = "Select * from course";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet result=stmt.executeQuery();
        query = "SELECT * from student2_course where students_StudentId = "+listOfStudent.get(0).getStudentId();
        stmt = con.prepareStatement(query);
        ResultSet stdCour = stmt.executeQuery();
        ArrayList<String> stdCourses = new ArrayList<>();
        while (stdCour.next()){
            stdCourses.add(stdCour.getString(2));
        }
    %>

    <div class="container">
        <div class="row ">
            <div class="col m6 offset-m3">
                <div class="card">
                    <div class="card-content">
                        <h3 class="center-align">Update Student Record</h3>
                        <div class="form center-align">
                            <form action="updateStd" method="post">
                                <%
                                    Object resultOfAdd =request.getAttribute("resultOfAdd");
                                    if (resultOfAdd != null){
                                        if (!resultOfAdd.toString().equals("0")){ %>
                                <p style="background-color:lightgreen;">Records added successfully...</p>
                                <% }
                                    if (resultOfAdd.toString().equals("0")) { %>
                                <p style="background-color:tomato;">Unable to add record...</p>
                                <%}
                                }%>
                                <input type="text" placeholder="Enter Student Name" name="name" value="<%= listOfStudent.get(0).getName() %>">
                                <input type="text" placeholder="Enter Roll Number" name="rollNum" value="<%= listOfStudent.get(0).getRollNum() %>">
                                <input type="text" placeholder="Enter Age" name="age" value="<%= listOfStudent.get(0).getAge() %>">
                                <input type="hidden" name="studentId" value="<%= listOfStudent.get(0).getStudentId() %>">
                                <div class="input-field col s12">
                                    <select name="course" multiple>
                                        <option value="" disabled selected>Choose your option</option>
                                        <%  while (result.next()){
                                            boolean flag=false;
                                            for (int i =0;i<stdCourses.size();i++){
                                                if (result.getString(1).equals(stdCourses.get(i))){%>
                                            <option selected value="<%= result.getString(1) %>"><%= result.getString(3)%></option>
                                        <%      flag=true;
                                                break;}
                                            }
                                            if (!flag) { %>
                                        <option value="<%= result.getString(1) %>"><%= result.getString(3)%></option>
                                        <%} }%>
                                    </select>
                                </div>

                                <p> <span>Gender</span>  &nbsp;  &nbsp;
                                    <% if (listOfStudent.get(0).getSex().equals("Male")) { %>
                                    <label>
                                        <input name="gender" type="radio" value="Male" checked />
                                        <span>Boy</span>  &nbsp;  &nbsp;
                                    </label>
                                    <label>
                                        <input name="gender" type="radio" value="Female" />
                                        <span>Girl</span>
                                    </label>
                                    <% } else{%>
                                    <label>
                                        <input name="gender" type="radio" value="Male" />
                                        <span>Boy</span>  &nbsp;  &nbsp;
                                    </label>
                                    <label>
                                        <input name="gender" type="radio" value="Female" checked />
                                        <span>Girl</span>
                                    </label>
                                    <% } %>
                                </p>
                                <button type="submit" class="btn" style="margin-top: 20px; width: 300px;">Update</button>
                            </form>
                            <a href="index.jsp">
                                <button type="button" class="btn" style="margin-top: 20px; width: 300px;">Back</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
<style>
    select {
        display: block;
    }
</style>