<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.StudentManagementSystemTask1.Student2" %><%--
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
                <a href="index.jsp" style="horiz-align: right">
                    <button type="button" class="btn" style="margin-top: 20px; width: 200px; horiz-align: right";>Back</button>
                </a>
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
                              ArrayList<Student2> listOfStudent = (ArrayList<Student2>) request.getAttribute("dataOfStudent");
                              if (listOfStudent!=null){
                              for (Student2 s : listOfStudent){ %>
                    <tr>
                        <td><%=s.getStudentId() %></td>
                        <td><%=s.getName()%></td>
                        <td><%=s.getSex() %></td>
                        <td><%=s.getRollNum() %></td>
                        <td><%=s.getAge() %></td>
                    </tr>
                        <% }
          }
        %>
            </div>
        </div>
    </div>
</body>
</html>
