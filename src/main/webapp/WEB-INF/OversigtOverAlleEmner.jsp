<%--
  Created by IntelliJ IDEA.
  User: 45213
  Date: 26/10/2021
  Time: 11.26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oversigt over alle emner</title>
</head>
<body>
<!--
Find out what is wrong here
-->
<h1>Here ${sessionScope.getFromDB}</h1>
<h1>Here we are</h1>
<%--
<c:forEach items="${sessionScope.getFromDB}" var="emne">
    <p>${emne} tilføjet af ${name}</p>
<br>
</c:forEach>--%>

<c:forEach var="type" items="${sessionScope.getFromDB}">
   Key is ${type.name}
   Value is ${type.emne}
   <br>
</c:forEach>


</body>
</html>
