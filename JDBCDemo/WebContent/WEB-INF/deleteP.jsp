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


	<h2>Effacer Pays</H2>



	<form method="post">

		<button name="menu3" type="submit">Menu</button>


		<p>
			<label for="idP">Entrée l'id du Pays a effacer</label> <input
				type="text" name="idP" id="idP">
		</p>



		<button name="delete1" type="submit">Effacer</button>


	</form>


	<ul>
		<c:forEach var="pays" items="${Lpays }">
			<li>n° <c:out value="${pays.id }" /> <c:out value="${pays.nom}" />
			</li>
		</c:forEach>
	</ul>



</body>
</html>