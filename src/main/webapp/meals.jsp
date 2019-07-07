<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<table id="meals" border="1">
    <tr>
        <th>Дата</th>
        <th>Тип еды</th>
        <th>Калории</th>
    </tr>

    <c:forEach var="meal" items="${mealsList}">
        <tr>
            <td> ${meal.getDateTime().toLocalDate()} ${meal.getDateTime().toLocalTime()} </td>
            <td> ${meal.getDescription()} </td>
            <td> ${meal.getCalories()} </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>