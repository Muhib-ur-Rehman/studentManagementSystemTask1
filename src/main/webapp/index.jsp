<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.StudentManagementSystemTask1.Student" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>

  <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

  <!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

  <div class="container">
    <div class="row ">
      <div class="col m6 offset-m3">
        <div class="card">
          <div class="card-content">
            <h3 class="center-align">Add Student Record</h3>
            <div class="form center-align">
              <form action="addStudent" method="post">
                <%
                  Object resultOfAdd =request.getAttribute("resultOfAdd");
                  if (resultOfAdd != null){
                  if (resultOfAdd.toString().equals("1")){ %>
                    <p style="background-color:lightgreen;">Records added successfully...</p>
                <% }
                  if (resultOfAdd.toString().equals("0")) { %>
                    <p style="background-color:tomato;">Unable to add record...</p>
                  <%}
                }%>
                <input type="text" placeholder="Enter Student Name" name="name">
                <input type="text" placeholder="Enter Roll Number" name="rollNum">
                <input type="text" placeholder="Enter Age" name="age">
                <p> <span>Gender</span>  &nbsp;  &nbsp;
                  <label>
                    <input name="gender" type="radio" value="Male" checked />
                    <span>Boy</span>  &nbsp;  &nbsp;
                  </label>
                  <label>
                    <input name="gender" type="radio" value="Female" />
                    <span>Girl</span>
                  </label>
                </p>

                <button type="submit" class="btn" style="margin-top: 20px; width: 300px;">Add Student</button>
              </form>
              <form action="fetchStudent" method="post">
                <button type="submit" class="btn" style="margin-top: 20px; width: 300px;">View all student</button>
              </form>
              <a href="searchUI.jsp">
                <button type="button" class="btn" style="margin-top: 20px; width: 300px;">Search</button>
              </a>
              <a href="deleteUI.jsp">
                <button type="button" class="btn" style="margin-top: 20px; width: 300px;">Delete</button>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>




  </div>

</body>
</html>