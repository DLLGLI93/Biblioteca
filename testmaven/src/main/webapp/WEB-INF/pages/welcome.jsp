

<%@page import="it.corsojava.testmaven.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DashBoard</title>
</head>
<body>

<!--  Con le % lavoro come se fossi dentro a un File Java -->
<%
 UserDto userInSession = (UserDto) session.getAttribute("userInSession");
%>

<div>
Benvenuto <%= userInSession.getUsername() %>
</div>
<p>
<div>
<a href="userList">Vai alla lista degli utenti</a>
</div>

<div>
<a href="pagina1">Crea nuovo utente</a>
</div>

<div>
<a href="indiceGestioneLibri.jsp">Gestione Libri</a>
</div>
</p>

</body>
</html>