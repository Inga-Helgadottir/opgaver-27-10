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
<div id="wrapper">
    <section class="forms">
        <section class="form1">
            <h2>Her kan du oprette dig som bruger.</h2>
            <form action="hello-servlet" method="post">
                <label for="name">Navn:</label><br>
                <input type="text" id="name" name="name" placeholder="John"><br><br>
                <label for="pass1">password:</label><br>
                <input type="password" id="pass1" name="pass1" placeholder="******"><br><br>
                <label for="pass2">gentag password:</label><br>
                <input type="password" id="pass2" name="pass2" placeholder="******"><br><br>
                <input type="submit" value="opret" class="btn">
            </form>
        </section>
        <section class="form2">
            <h2>Her kan du log ind på din bruger.</h2>
            <form action="Login" method="post">
                <label for="name2">Navn:</label><br>
                <input type="text" id="name2" name="name" placeholder="John"><br><br>
                <label for="pass">password:</label><br>
                <input type="password" id="pass" name="password" placeholder="******"><br><br>
                <input type="submit" value="login" class="btn">
            </form>
        </section>
    </section>
<%---------------------------testing db-----------------------------------------------
    <form action="DBServlet" method="get">
        <label for="name2">Navn:</label><br>
        <input type="text" id="name2" name="name" placeholder="John"><br><br>
        <label for="pass">password:</label><br>
        <input type="text" id="pass" name="pass1" placeholder="******"><br><br>
        <input type="submit" value="opret" class="btn">
    </form>
--%>
    <a class="helloServlet" href="hello-servlet">Hello Servlet</a>
</div>
</body>
</html>
