<%-- 
    Document   : index
    Created on : May 24, 2016, 10:39:36 PM
    Author     : kb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="processCalculator">
            Number one <input name="num1" type="text" /><BR/>
            Number two <input name="num2" type="text" /><BR/>
            <input type="submit" value="Add" name="add" />
            <input type="submit" value="Subtract" name="subtract"/>
        </form>
    </body>
</html>
