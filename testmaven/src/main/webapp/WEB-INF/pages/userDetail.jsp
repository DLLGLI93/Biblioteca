
<%@page import="it.corsojava.testmaven.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UserVo vo = (UserVo) request.getAttribute("user");
	%>

<form action="updateUser" method="Post">  
	<div>
		<label for="id">Id(nascosto) </label> <input type="hidden" id="id" name="userId"
			value="<%=vo.getId()%>" >
	</div>
	<div>
		<label for="name">Nome: </label> <input type="text" id="name"
			name="name" value="<%=vo.getUsername()%>">
	</div>
	<div>
		<label for="psw">Password: </label> <input type="password" id="psw"
			name="psw" value="<%=vo.getPsw()%>">
	</div>
 </form>

</body>
</html>