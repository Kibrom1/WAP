<%-- 
    Document   : search
    Created on : May 25, 2016, 2:45:13 PM
    Author     : 984763
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Student</title>
    </head>
    <body>
        <form action="StudentServlet" method="GET">
            Enter Id: <input type="text" name="id" placeholder="Enter Id"/><br>
            <input type="Submit" value="Cancel" name="cancelFind"/>
            <input type="Submit" value="Find" name="find"/>
        </form>
    </body>
</html>
