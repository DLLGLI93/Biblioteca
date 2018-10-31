<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dati di un nuovo Libro</title>
</head>

<body>
	<form action="caricaDati">
		<div>
			<label for="titolo">Titolo: </label> <input type="text" id="titolo"
				name="titiolo">
		</div>
		<div>
			<label for="autore">Autore: </label> <input type="text"
				id="autore" name="autore">
		</div>
		<div>
			<label for="anno">Anno: </label> <input type="text"anno" name="anno">
		</div>
		<input type="submit" value="Invia">
	</form>
</body>
</html>