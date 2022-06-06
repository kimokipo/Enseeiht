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
<% Collection<Campagne> lc = (Collection<Campagne>) request.getAttribute("listercampagnes");
String lien = (String)request.getAttribute("lien");
%>
	 <table border="1" width="80%">
	 <tr> <th>Nom</th><th>date debut</th><th>date fin</th><th>Objectifs</th><th>contexte</th></tr>
 <% for(Campagne c : lc){%>
	 <tr><td><%=c.getNom() %></td><td><%=c.getDateDebut() %></td><td><%=c.getDateFin() %></td><td><%=c.getObjectif() %></td><td><%=c.getContexte()%></td></tr>
   
     <%} %>
      </table>
     

<input type="hidden" name="op" value="listerCampagnes">
<br><a href=<%=lien%>>Retour au Menu</a></br> 
</center>
</form>

</body>
</html>