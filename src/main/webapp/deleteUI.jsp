<%--
  Created by IntelliJ IDEA.
  User: mrehman
  Date: 17/08/2021
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>
<body>
<div class="container">
    <div class="row ">
        <div class="col m6 offset-m3">
            <div class="card">
                <div class="card-content">
                    <h3 class="center-align">Delete Student Record</h3>
                    <%
                        Object resultOfAdd =request.getAttribute("resultOfAdd");
                        if (resultOfAdd != null){
                            if (resultOfAdd.toString().equals("1")){ %>
                    <p style="background-color:lightgreen;">Record deleted successfully...</p>
                    <% }
                        if (resultOfAdd.toString().equals("0")) { %>
                    <p style="background-color:tomato;">Invalid Roll Number, Try again...</p>
                    <%}
                    }%>
                    <div class="form center-align">
                        <form action="DeleteStudent" method="post">
                            <input type="text" placeholder="Enter Roll Number" name="rollNum">

                            <button type="submit" class="btn" style="margin-top: 20px; width: 300px;">Delete</button>
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
