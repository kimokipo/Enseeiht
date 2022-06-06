<%@ page language="java" import="pack.*, java.util.*" contentType="text/html; charset=UTF-8"
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
<% Collection<Groupe> lg = (Collection<Groupe>) request.getAttribute("listergroupes");
String lien = (String)request.getAttribute("lien");%>

	<table border="1" width="80%">
	 <tr> <th>Nom</th><th>nombre de membres</th><th>theme</th><th>type</th><th>reglementation</th><th>url</th><th>frequence des posts</th><th>format</th><th>lieu</th></tr>

 <% for(Groupe g : lg){%>
	 <tr><td><%=g.getNom() %></td><td><%=g.getNombreMembres()%></td><td><%=g.getTheme() %></td><td><%=g.getType() %></td><td><%=g.getReglementation()%></td><td><%=g.getUrl()%></td><td><%=g.getFrequence() %></td><td><%=g.getFormat() %></td><td><%=g.getLieu() %></td></tr>
   
     <%} %>
      </table>
     

<input type="hidden" name="op" value="listerGroupes">
 <br><a href=<%=lien %>>Retour au Menu</a></br> 
</center>
</form>

</body>
</html>