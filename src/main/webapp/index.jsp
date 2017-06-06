<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>person list</title>
    </head>
	<body>
        <table border="1">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>score</th>
                <th>discount</th>
            </tr>
            <c:forEach items="${ranks}" var="rank">
                <tr>
                    <td>${rank.id}</td>
                    <td>${rank.name}</td>
                    <td>${rank.score}</td>
                    <td>${rank.discount}</td>
                </tr>
            </c:forEach>
        </table>
	</body>
</html>
