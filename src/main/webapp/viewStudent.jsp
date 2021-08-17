<%@ page import="com.example.StudentManagementSystemTask1.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: mrehman
  Date: 17/08/2021
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>
<body>
    <div class="container">
        <div class="row ">
            <div class="col m8 offset-m1">
                <h1>Displaying Students</h1>
                <table border ="1" width="500" align="center">
                    <tr bgcolor="00FF7F">
                        <th><b>Id</b></th>
                        <th><b>Name</b></th>
                        <th><b>Gender</b></th>
                        <th><b>Roll Number</b></th>
                        <th><b>Age</b></th>
                    </tr>
                        <%
                              ArrayList<Student> listOfStudent = (ArrayList<Student>) request.getAttribute("dataOfStudent");
                              if (listOfStudent!=null){
                              for (Student s : listOfStudent){ %>
                    <tr>
                        <td><%=s.studentId %></td>
                        <td><%=s.name %></td>
                        <td><%=s.gender %></td>
                        <td><%=s.rollNum %></td>
                        <td><%=s.age %></td>
                    </tr>
                        <% }
          }
        %>
            </div>
        </div>
    </div>
</body>
</html>
