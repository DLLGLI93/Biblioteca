
<%@page import="it.corsojava.testmaven.dto.NuovoUtenteDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina riassuntiva</title>
</head>
<body>

<% NuovoUtenteDto nDto = (NuovoUtenteDto) session.getAttribute("nuovoUtente");
%>
<h2>Riassunto dati inseriti:</h2>
<div> 
Nome: <%=nDto.getNome() %>
</div>
<div> 
Cognome: <%=nDto.getCognome() %>
</div>
<div> 
Nome Utente: <%=nDto.getUsername() %>
</div>
<div> 
Codice Fiscale: <%=nDto.getCf() %>
</div>
<div> 
Email: <%=nDto.getEmail() %>
</div>

<% session.removeAttribute("nuovoUtente"); %>

</body>
</html>