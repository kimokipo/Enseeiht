<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action= "Calcul" method="get">
nb1 : <input type="text" name="nb1" value="${nb1}"><br/>
nb2 : <input type="text" name="nb2" value="${nb2}"><br/>
<input type="submit" name="op" value="compute">
<%if (request.getAttribute("result") != null) { %>
la somme de ${nb1} et ${nb2} est ${result} 
<% } %>
</form>
</body>
</html>