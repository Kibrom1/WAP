<%-- 
    Document   : add
    Created on : May 25, 2016, 2:44:36 PM
    Author     : 984763
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
    </head>
    <body>
        <form action="StudentServlet" method="POST">
            Id: <input type="text" name="id" placeholder="Enter Id"/><br><br>
            Name : <input type="text" name="name" placeholder="Enter Name"/><br><br>
            GPA : <input type="text" name="gpa" placeholder="Enter Name"/> <br><br>
            Gender : <input type="radio" name="gender" value="male"/> Male
            <input type="radio" name="gender" value="female"/>Female <br><br>
            <input type="reset" value="Reset" name="reset"/>
            <input type="submit" value="Cancel" name="cancelAdd"/>
            <input type="submit" value="Add" name="add"/>
        </form>
    </body>
</html>
