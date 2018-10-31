
<%@page import="it.corsojava.testmaven.vo.UserVo"%>
<%@page import="it.corsojava.testmaven.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!--  Con le % lavoro come se fossi dentro a un File Java -->
	<%
		UserDto userInSession = (UserDto) session.getAttribute("userInSession");
		List<UserVo> userList = (List<UserVo>) request.getAttribute("userList");
	%>

	<div>
		Benvenuto
		<%=userInSession.getUsername()%>
	</div>

	<%
		if (userList != null && userList.size() > 0) {
	%>
	<!-- TABELLA HTML -->
	<table>

		<thead>
			<tr>
				<th>ID </th>
				<th>USERNAME</th>
				<th>PSW</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (UserVo vo : userList) {
			%>
			<tr>
				<td>
				<a href="searchUser?userId=<%=vo.getId()%>"> <%=vo.getId()%> </a>
				</td>
				<td><%=vo.getUsername()%></td>
				<td><%=vo.getPsw()%></td>
			</tr>
			<%
				}
			%>
		</tbody>

	</table>

	<%
		} else {
	%>
	<div>
		<!--  con <p> faccio un nuovo paragrafo -->
		<p>Nessun utente trovato
		<p>
	</div>

	<%
		}
	%>

	<div>
		<a href="logout"> Logout</a>
	</div>
</body>
</html>