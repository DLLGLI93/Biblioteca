<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h2>Effettua il Login:</h2>
<form action="login" method="post">
<div>
<label for="idusername">Username: </label>
<input type= "text" id="idusername" name="nomeInserito">
</div>
<div>
<label for="idpassword">Password: </label>
<input type= "password" id="idpassword" name="psw">
</div>
<input type="submit" value = "Invia">
</form>

</body>
</html>