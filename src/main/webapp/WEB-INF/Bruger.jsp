<%--
  Created by IntelliJ IDEA.
  User: 45213
  Date: 26/10/2021
  Time: 09.47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Brugerside</title>
</head>
<body>
Du er nu logget ind som ${sessionScope.navn} <br>
<%--  sessionScope lasts for a session but requestScope only shows one time
Du er nu logget ind som ${requestScope.navn} <br>--%>
<%--med sessionid ${requestScope.session}--%>

<h2>Her kan du tilføje emner til din huskeliste</h2><br>

du har nu til ${sessionScope.emneListeSize} emner

<form action="TilføjEmne" method="post">
    <label for="emne">Emne:</label><br>
    <input type="text" id="emne" name="emne" placeholder="Øl Bong !"><br>
    <input type="submit" value="Tilføj emne">
</form>

<form action="SletEmne" method="post">
    <label for="sletEmne">slet emne:</label><br>
    <input type="text" id="sletEmne" name="emne" placeholder="Øl Bong !"><br>
    <input type="submit" value="Slet emne">
</form>

<c:forEach items="${sessionScope.emneListe}" var="emne">
    ${emne}
    <br>
</c:forEach>

<form action="VisOversigtServlet" method="get">
    <input type="submit" value="gå til oversigt">
</form>

<h1>alle emner er tilføjet af brugere</h1>

<c:forEach items="${applicationScope.alleBrugeresEmner}" var="emne">
    ${emne}
    <br>
</c:forEach>
</body>
</html>
