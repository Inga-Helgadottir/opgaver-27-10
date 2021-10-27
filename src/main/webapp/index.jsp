<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - huskesedel</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<h1><%= "Velkommen til online huskesedel" %>
${requestScope.msg}<br>
</h1>
<br/>
<br>

<h2>Her kan du oprette dig som bruger.</h2>
<br>
<br>
<!--
<form action="hello-servlet" method="get">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="pwd">Password:</label><br>
    <input type="password" id="pwd" name="pwd"><br>
    <label for="pwd2">Password:</label><br>
    <input type="password" id="pwd2" name="pwd2"><br>
    <input type="submit" value="submit">
</form>
-->
<form id="form" action="hello-servlet" method="get">
    <label for="name">Navn:</label><br>
    <input type="text" id="name" name="name" value="John"><br><br>
    <label for="pass1">password:</label><br>
    <input type="text" id="pass1" name="pass1"><br><br>
    <label for="pass2">gentag password:</label><br>
    <input type="text" id="pass2" name="pass2"><br><br>
    <input type="submit" value="opret">
</form>

<a href="hello-servlet">Hello Servlet</a>
</body>
</html>