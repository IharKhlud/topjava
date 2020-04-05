<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.javawebinar.topjava.util.MealsUtil" %>
<%@ page import="ru.javawebinar.topjava.model.Meal" %>
<%@ page import="ru.javawebinar.topjava.model.MealTo" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="meals" class="ru.javawebinar.topjava.web.MealServlet" scope="page"></jsp:useBean>
<html>
<head>
    <title>Users</title>
</head>
<body>
<ul>
    <li><a href="index.html">Home</a> </li>
    <li><a href="users">Users</a></li>
</ul>
<hr>
<h2>Meals GRUD</h2>
    <table border="1" cellspacing="0" cellpadding="2">
        <c:forEach items="${meals.mealTo}" var="i" >
        <tr <c:if test="${i.excess == true}"><c:out value="style=color:red"></c:out></c:if>>
            <td>${i.dateTimeToString}</td>
            <td>${i.description}</td>
            <td>${i.calories}</td>
        </tr>
        </c:forEach>

    </table>
</body>
</html>