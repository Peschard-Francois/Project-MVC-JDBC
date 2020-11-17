<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<H1>Modification de la table Pays</H1>

	<form method="post" action="">


		<button name="add" type="submit">Ajouter</button>
		<button name="modi" type="submit">Modifier</button>
		<button name="delete" type="submit">Effacer</button>

	</form>
	<br>
	<br>
	<br>
	<ul>
		<c:forEach var="pays" items="${Lpays }">
			<li>n° <c:out value="${pays.id }" /> <c:out value="${pays.nom}" />
			</li>
		</c:forEach>
	</ul>

</body>
</html>