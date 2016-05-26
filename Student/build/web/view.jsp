<%-- 
    Document   : view
    Created on : May 25, 2016, 2:44:48 PM
    Author     : 984763
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All</title>
    </head>
    <body>
        <table border='2'>
            <tbody>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>GPA</th>
                    <th>Gender</th>
                </tr>
                <c:forEach items="${listStudent}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.gpa}</td>
                        <td>${student.gender}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="home.jsp">
            <input type="submit" value="Done">
        </form>
    </body>
</html>
