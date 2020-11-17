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



	<h2>Ajouter Pays</H2>




	<form method="post">

		<button name="menu" type="submit">Menu</button>


		<p>
			<label for="nomP">Entrée le Pays a ajouter</label> <input type="text"
				name="nomP" id="nomP">
		</p>


		<button name="add1" type="submit">Ajouter</button>


	</form>


	<ul>
		<c:forEach var="pays" items="${Lpays }">
			<li>n° <c:out value="${pays.id }" /> <c:out value="${pays.nom}" />
			</li>
		</c:forEach>
	</ul>



</body>
</html>