<%-- 
    Document   : detail
    Created on : May 25, 2016, 2:45:23 PM
    Author     : 984763
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details</title>
    </head>
    <body>
        <form action="StudentServlet" method="GET">
            <input type="text" name="id" value=${student.id}/>
            Name: ${student.name}<br>
            Gender:${student.gender}<br>
            Gender:${student.gender}<br>
            GPA:${student.gpa}
            <br>
            <input type="submit" name="cancelDelete" value="Cancel"/>
            <input type="submit" name="deleteStudent" value="Delete"/>
        </form>
    </body>
</html>
