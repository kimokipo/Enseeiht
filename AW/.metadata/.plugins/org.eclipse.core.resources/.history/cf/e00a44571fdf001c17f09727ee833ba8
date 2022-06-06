<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action= "Controler" method="get">
<center>
url_post <input type="text" name="url_post"><br/>
<br/>
date_releve <input type="text" name="date_releve"><br/>
nombre de likes <input type="text" name="nb_likes"><br/>
nombre de commentaires <input type="text" name="nb_comments"><br/>
nombre de partages <input type="text" name="nb_shares"><br/>
<input type="hidden" name="op" value="ajoutReleve">
<input type="submit" name="ajouter" value="add">
<br/><% String message = (String)request.getAttribute("message"); %>
<% if(message != null) { %>
	<%=message%>
 <% } %><br/>
 <a href="managerConnect.html">Retour au Menu</a>
</center>

</form>

</body>
</html>